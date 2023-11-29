package com.pss.presenter;

import com.pss.state.view.PainelMenuState;

import com.pss.view.PainelMenu;

public class PainelMenuPresenter {
    private TelaPrincipalPresenter telaPresenter;

    private PainelMenuState estado;

    public PainelMenuPresenter(TelaPrincipalPresenter telaPresenter, PainelMenuState estado) {
        this.telaPresenter = telaPresenter;
        this.estado = estado;
    }

    public TelaPrincipalPresenter getTelaPresenter() {
        return this.telaPresenter;
    }

    public PainelMenu getPainel() {
        return this.telaPresenter.getPainelMenu();
    }
    
    public PainelMenuState getEstado() {
        return this.estado;
    }
}
