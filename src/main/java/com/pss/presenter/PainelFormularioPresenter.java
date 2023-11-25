package com.pss.presenter;

import com.pss.state.view.PainelFormularioState;

import com.pss.view.PainelFormulario;

public class PainelFormularioPresenter {
    private TelaPrincipalPresenter telaPresenter;

    private PainelFormularioState estado;

    public PainelFormularioPresenter(TelaPrincipalPresenter telaPresenter, PainelFormularioState estado) {
        this.telaPresenter = telaPresenter;
        this.estado = estado;
    }

    public TelaPrincipalPresenter getTelaPresenter() {
        return this.telaPresenter;
    }

    public PainelFormulario getPainel() {
        return this.telaPresenter.getPainelFormulario();
    }
    
    public PainelFormularioState getEstado() {
        return this.estado;
    }
}
