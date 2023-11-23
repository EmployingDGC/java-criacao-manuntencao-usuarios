package com.pss.presenter;

import javax.swing.JButton;

import com.pss.state.view.PainelFormularioState;
import com.pss.view.PainelFormulario;

public class PainelFormularioPresenter {
    private TelaPrincipalPresenter telaPresenter;

    private PainelFormulario painel;

    private PainelFormularioState estado;

    public PainelFormularioPresenter(TelaPrincipalPresenter telaPresenter, PainelFormulario painel, PainelFormularioState estado) {
        this.telaPresenter = telaPresenter;
        this.painel = painel;
        this.estado = estado;
    }

    public TelaPrincipalPresenter getTelaPresenter() {
        return this.telaPresenter;
    }

    public PainelFormulario getPainel() {
        return this.painel;
    }
    
    public PainelFormularioState getEstado() {
        return this.estado;
    }

    public JButton getBotaoEntrar() {
        return this.painel.getBotaoEntrar();
    }
}
