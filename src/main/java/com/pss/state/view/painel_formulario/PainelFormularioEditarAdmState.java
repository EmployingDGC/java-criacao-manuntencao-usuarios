package com.pss.state.view.painel_formulario;

import java.awt.event.ActionListener;

import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.state.view.PainelFormularioState;

import com.pss.view.PainelFormulario;

public class PainelFormularioEditarAdmState extends PainelFormularioState {
    private ActionListener acaoDoBotaoSalvar;
    private ActionListener acaoDoBotaoVoltar;

    public PainelFormularioEditarAdmState(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter);
    }

    @Override
    public void aplicarEstado() {
        super.aplicarEstado();

        PainelFormulario pf = this.getPainel();

        pf.getTelaPresenter().getTela().setTitulo("Editar Usuário");

        pf.getCampoUsuario().setEditable(false);
        pf.getCampoUsuario().setVisible(true);
        pf.getCampoSenha().setVisible(true);
        pf.getCampoNome().setVisible(true);

        pf.getLabelUsuario().setVisible(true);
        pf.getLabelSenha().setVisible(true);
        pf.getLabelNome().setVisible(true);

        pf.getBotaoSalvar().setVisible(true);
        pf.getBotaoVoltar().setVisible(true);

        pf.getCheckBoxAdministrador().setVisible(true);
        pf.getCheckBoxAdministrador().setSelected(true);
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
