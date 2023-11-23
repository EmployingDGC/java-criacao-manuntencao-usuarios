package com.pss.state.view.painel_formulario;

import java.awt.event.ActionListener;

import com.pss.state.view.PainelFormularioState;

import com.pss.view.PainelFormulario;

public class PainelFormularioEntrarState extends PainelFormularioState {
    private ActionListener acaoDoBotaoRegistrar;
    private ActionListener acaoDoBotaoEntrar;

    public PainelFormularioEntrarState(PainelFormulario painel) {
        super(painel);
    }

    @Override
    public void aplicarEstado() {
        super.aplicarEstado();

        PainelFormulario pf = this.getPainel();

        pf.getTela().setTitulo("Entrar");

        pf.getCampoUsuario().setVisible(true);
        pf.getCampoSenha().setVisible(true);

        pf.getLabelUsuario().setVisible(true);
        pf.getLabelSenha().setVisible(true);

        pf.getBotaoRegistrar().setVisible(true);
        pf.getBotaoEntrar().setVisible(true);

        pf.revalidate();
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
            this.getPainel().getBotaoRegistrar().removeActionListener(this.acaoDoBotaoEntrar);
        }

        this.getPainel().getBotaoEntrar().addActionListener(acao);
        this.acaoDoBotaoEntrar = acao;
    }
}
