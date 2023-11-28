package com.pss.state.view.tela;

import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.state.view.TelaState;

import com.pss.view.Tela;

public class TelaUsuarioState extends TelaState {
    public TelaUsuarioState(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter);
    }

    @Override
    public void aplicarEstado() {
        super.aplicarEstado();

        Tela tela = this.getTelaPresenter().getTela();

        tela.getBotaoNotificaoes().setVisible(true);
    }
}
