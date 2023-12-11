package com.pss.command;

import javax.swing.JOptionPane;

import com.pss.collection.UsuarioCollection;

import com.pss.error.usuario.NomeDaPessoaObrigatorioError;
import com.pss.error.usuario.SenhaDoUsuarioObrigatorioError;

import com.pss.model.log.LogAlteracaoUsuarioModel;
import com.pss.model.log.LogAutorizacaoUsuarioModel;
import com.pss.model.log.LogInclusaoUsuarioModel;
import com.pss.model.usuario.AdministradorModel;
import com.pss.model.usuario.UsuarioModel;

import com.pss.presenter.painel_formulario.PainelFormularioEditarAdmPresenter;
import com.pss.presenter.painel_formulario.PainelFormularioEntrarPresenter;
import com.pss.presenter.painel_formulario.PainelFormularioRegistrarPresenter;

import com.pss.service.EnviarMensagemService;
import com.pss.service.FiltrarUsuarioService;

import com.pss.view.PainelFormulario;

public class PainelFormularioCommand {
    static public void registrarUsuario(PainelFormularioRegistrarPresenter painelPresenter) {
        PainelFormulario painel = painelPresenter.getPainel();
        
        String textoCampoNome = painel.getCampoNome().getText();
        String textoCampoUsuario = painel.getCampoUsuario().getText();
        String textoCampoSenha = painel.getCampoSenha().getText();
        
        LogInclusaoUsuarioModel log = new LogInclusaoUsuarioModel(textoCampoUsuario);

        try {
            UsuarioModel u;

            if (UsuarioCollection.getInstancia().getUsuarios().isEmpty()) {
                u = new AdministradorModel(textoCampoNome, textoCampoUsuario, textoCampoSenha);
                u.aprovarCadastro();

                UsuarioCollection.getInstancia().add(u);
            }

            else {
                u = EnviarMensagemService
                    .solicitacaoCadastro(textoCampoNome, textoCampoUsuario, textoCampoSenha);
            }

            System.out.println(log.toStringSucesso());
            painelPresenter.getTelaPresenter().vaParaEntrar();
        } catch (RuntimeException exp) {
            System.out.println(log.toStringFalha(exp.getMessage()));
        }
    }

    static public void logarUsuario(PainelFormularioEntrarPresenter painelPresenter) {
        PainelFormulario painel = painelPresenter.getPainel();

        String textoCampoUsuario = painel.getCampoUsuario().getText();
        String textoCampoSenha = painel.getCampoSenha().getText();

        UsuarioModel u = FiltrarUsuarioService.usuarioESenha(textoCampoUsuario, textoCampoSenha);

        LogAutorizacaoUsuarioModel log = new LogAutorizacaoUsuarioModel(textoCampoUsuario);

        if (u == null) {
            System.out.println(log.toStringFalha("Usuário e/ou Senha incorreto(s)"));
            return;
        }

        if (!u.isCadastroAprovado()) {
            System.out.println(log.toStringFalha("Cadastro do usuário Não aprovado"));
            return;
        }

        painelPresenter.getTelaPresenter().setUsuarioLogado(u);
        System.out.println(log.toStringSucesso());
    }

    static public void salvarAlteracoesUsuario(PainelFormularioEditarAdmPresenter painelPresenter) {
        UsuarioModel u = painelPresenter.getUsuario();

        painelPresenter.getPainel().getCheckBoxAdministrador().setSelected(u.isAdministrador());

        boolean admChecked = painelPresenter.getPainel().getCheckBoxAdministrador().isSelected();

        String mensagemAdm;

        if (!u.isAdministrador() && admChecked) {
            mensagemAdm = String.format("\nOBS.: Ao confirmar, o usuário %s será um administrador", u.getUsuario());
        } else if (u.isAdministrador() && !admChecked) {
            mensagemAdm = String.format("\nOBS.: Ao confirmar, o usuário %s deixará de ser um administrador", u.getUsuario());
        } else {
            mensagemAdm = "";
        }

        int resposta = JOptionPane.showConfirmDialog(
            painelPresenter.getTelaPresenter().getTela(),
            String.format("Deseja confirmar as alterações para o usuário %s%s", u.getUsuario(), mensagemAdm),
            String.format("Editando usuário %s", u.getUsuario()),
            JOptionPane.YES_NO_OPTION
        );

        LogAlteracaoUsuarioModel log = new LogAlteracaoUsuarioModel(u.getUsuario());

        if (resposta == JOptionPane.YES_OPTION) {
            String novoUsuario = painelPresenter.getPainel().getCampoUsuario().getText();
            String novaSenha = painelPresenter.getPainel().getCampoSenha().getText();
            String novoNome = painelPresenter.getPainel().getCampoNome().getText();

            UsuarioModel uTmp;

            try {
                uTmp = new UsuarioModel(novoNome, novoUsuario, novaSenha);
            } catch (NomeDaPessoaObrigatorioError exp) {
                System.out.println(log.toStringFalha(exp.getMessage()));
                return;
            } catch (SenhaDoUsuarioObrigatorioError exp) {
                System.out.println(log.toStringFalha(exp.getMessage()));
                return;
            }

            if (uTmp.getNome() != u.getNome() || uTmp.getSenha() != u.getSenha()) {
                System.out.println(log.toStringSucesso());
            }

            u.setNome(novoNome);
            u.setSenha(novaSenha);

            JOptionPane.showConfirmDialog(
                painelPresenter.getTelaPresenter().getTela(),
                String.format("As alterações para o usuário %s foram aplicadas", u.getUsuario()),
                String.format("Edição confirmada", u.getUsuario()),
                JOptionPane.DEFAULT_OPTION
            );

            if (painelPresenter.getTelaPresenter().getUsuarioLogado().isAdministrador()) {
                painelPresenter.getTelaPresenter().vaParaMenuAdministrador();
            } else {
                painelPresenter.getTelaPresenter().vaParaMenuUsuario();
            }

            painelPresenter.sairPainel();
        }
    }
}
