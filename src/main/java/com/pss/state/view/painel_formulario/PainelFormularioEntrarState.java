package com.pss.state.view.painel_formulario;

import java.awt.event.ActionListener;

import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.state.view.PainelFormularioState;

import com.pss.view.PainelFormulario;

public class PainelFormularioEntrarState extends PainelFormularioState {
    private ActionListener acaoDoBotaoRegistrar;
    private ActionListener acaoDoBotaoEntrar;

    public PainelFormularioEntrarState(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter);
    }

    @Override
    public void aplicarEstado() {
        super.aplicarEstado();

        TelaPrincipalPresenter tp = this.getTelaPresenter();

        tp.getTela().setPainelMeio(tp.getPainelFormulario());

        PainelFormulario pf = this.getPainel();

        pf.getTelaPresenter().getTela().setTitulo("Entrar");

        pf.getCampoUsuario().setVisible(true);
        pf.getCampoSenha().setVisible(true);

        pf.getLabelUsuario().setVisible(true);
        pf.getLabelSenha().setVisible(true);

        pf.getBotaoRegistrar().setVisible(true);
        pf.getBotaoEntrar().setVisible(true);
    }
    
    public void setAcaoDoBotaoRegistrar(ActionListener acao) {
        if (this.acaoDoBotaoRegistrar != null) {
            this.getPainel().getBotaoRegistrar().removeActionListener(this.acaoDoBotaoRegistrar);
        }

        this.getPainel().getBotaoRegistrar().addActionListener(acao);
        this.acaoDoBotaoRegistrar = acao;
    }

    public void setAcaoDoBotaoEntrar(ActionListener acao) {
        if (this.acaoDoBotaoEntrar != null) {
            this.getPainel().getBotaoEntrar().removeActionListener(this.acaoDoBotaoEntrar);
        }

        this.getPainel().getBotaoEntrar().addActionListener(acao);
        this.acaoDoBotaoEntrar = acao;
    }
}
