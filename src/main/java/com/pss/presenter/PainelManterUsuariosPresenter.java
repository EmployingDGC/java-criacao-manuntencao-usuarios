package com.pss.presenter;

import com.pss.state.view.PainelManterUsuariosState;

import com.pss.view.PainelManterUsuarios;

public class PainelManterUsuariosPresenter {
    private TelaPrincipalPresenter telaPresenter;

    private PainelManterUsuariosState estado;

    public PainelManterUsuariosPresenter(TelaPrincipalPresenter telaPresenter, PainelManterUsuariosState estado) {
        this.telaPresenter = telaPresenter;
        this.estado = estado;
    }

    public TelaPrincipalPresenter getTelaPresenter() {
        return this.telaPresenter;
    }

    public PainelManterUsuarios getPainel() {
        return this.telaPresenter.getPainelManterUsuarios();
    }
    
    public PainelManterUsuariosState getEstado() {
        return this.estado;
    }
}
