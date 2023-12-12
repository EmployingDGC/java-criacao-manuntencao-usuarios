package com.pss.command;

import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;

import com.pss.collection.UsuarioCollection;
import com.pss.model.LogModel;
import com.pss.model.log.LogAlteracaoUsuarioModel;
import com.pss.model.log.LogExclusaoUsuarioModel;
import com.pss.model.usuario.UsuarioModel;
import com.pss.presenter.painel_manter_usuarios.PainelManterUsuariosAdmPresenter;

public class ManterUsuarioCommand {
    static public List<UsuarioModel> obterUsuarios(PainelManterUsuariosAdmPresenter presenter) {
        List<UsuarioModel> usuarios = new ArrayList<>();

        int[] ids = presenter.getPainel().getIdsLinhasSelecionadas();

        for (int id : ids) {
            usuarios.add(presenter.getUsuarios().get(id));
        }

        return usuarios;
    }
    
    static public void editarUsuario(PainelManterUsuariosAdmPresenter presenter) {
        List<UsuarioModel> usuarios = obterUsuarios(presenter);

        LogModel log = new LogAlteracaoUsuarioModel(presenter.getTelaPresenter().getUsuarioLogado().getUsuario());

        if (usuarios.size() == 0) {
            System.out.println(log.toStringFalha("Nenhuma linha da tabela selecionada"));
            return;
        }

        if (usuarios.size() > 1) {
            System.out.println(log.toStringFalha("Favor selecionar apenas um usuário"));
            return;
        }

        UsuarioModel u = usuarios.get(0);

        presenter.sairPainel();
        presenter.getTelaPresenter().vaParaEditarAdministrador(u);
    }
    
    static public void excluirUsuario(PainelManterUsuariosAdmPresenter presenter) {
        List<UsuarioModel> usuarios = obterUsuarios(presenter);

        LogModel log = new LogExclusaoUsuarioModel(presenter.getTelaPresenter().getUsuarioLogado().getUsuario());

        if (usuarios.size() == 0) {
            System.out.println(log.toStringFalha("Nenhuma linha da tabela selecionada"));
            return;
        }

        String uString = "";

        for (UsuarioModel u : usuarios) {
            uString += String.format("%s\n", u.getUsuario());
        }

        int resposta = JOptionPane.showConfirmDialog(
            presenter.getTelaPresenter().getTela(),
            String.format("Deseja apagar os seguintes usuários?\n%s", uString),
            String.format("Excluindo %d usuários", usuarios.size()),
            JOptionPane.YES_NO_OPTION
        );

        if (resposta == JOptionPane.YES_OPTION) {
            for (UsuarioModel u : usuarios) {
                UsuarioCollection.getInstancia().getUsuarios().remove(u);
                System.out.println(log.toStringSucesso());
            }

            JOptionPane.showConfirmDialog(
                presenter.getTelaPresenter().getTela(),
                String.format("%d usuários foram excluídos", usuarios.size()),
                "Exclusão confirmada",
                JOptionPane.DEFAULT_OPTION
            );

            presenter.sairPainel();
            presenter.getTelaPresenter().vaParaMenuAdministrador();
        }
    }
}
