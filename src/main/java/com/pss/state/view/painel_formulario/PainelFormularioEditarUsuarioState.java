package com.pss.state.view.painel_formulario;

import java.awt.event.ActionListener;

import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.state.view.PainelFormularioState;

import com.pss.view.PainelFormulario;

public class PainelFormularioEditarUsuarioState extends PainelFormularioState {
    private ActionListener acaoDoBotaoSalvar;
    private ActionListener acaoDoBotaoVoltar;

    public PainelFormularioEditarUsuarioState(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter);
    }

    @Override
    public void aplicarEstado() {
        super.aplicarEstado();

        PainelFormulario pf = this.getPainel();

        pf.getTelaPresenter().getTela().setTitulo("Editar Usuário");

        pf.getCampoSenhaAtual().setVisible(true);
        pf.getCampoNovaSenha().setVisible(true);
        pf.getCampoUsuario().setVisible(true);
        pf.getCampoNome().setVisible(true);
        
        pf.getCampoUsuario().setEditable(false);

        pf.getLabelSenhaAtual().setVisible(true);
        pf.getLabelNovaSenha().setVisible(true);
        pf.getLabelUsuario().setVisible(true);
        pf.getLabelNome().setVisible(true);

        pf.getBotaoSalvar().setVisible(true);
        pf.getBotaoVoltar().setVisible(true);
    }
    
    public void setAcaoDoBotaoSalvar(ActionListener acao) {
        if (this.acaoDoBotaoSalvar != null) {
            this.getPainel().getBotaoSalvar().removeActionListener(this.acaoDoBotaoSalvar);
        }

        this.getPainel().getBotaoSalvar().addActionListener(acao);
        this.acaoDoBotaoSalvar = acao;
    }

    public void setAcaoDoBotaoVoltar(ActionListener acao) {
        if (this.acaoDoBotaoVoltar != null) {
            this.getPainel().getBotaoVoltar().removeActionListener(this.acaoDoBotaoVoltar);
        }

        this.getPainel().getBotaoVoltar().addActionListener(acao);
        this.acaoDoBotaoVoltar = acao;
    }
}
