package com.pss.state.view.tela;

import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.state.view.TelaState;

import com.pss.view.Tela;

public class TelaAdministradorState extends TelaState {
    public TelaAdministradorState(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter);
    }

    @Override
    public void aplicarEstado() {
        super.aplicarEstado();

        Tela tela = this.getTelaPresenter().getTela();

        tela.getBotaoSolicitacoes().setVisible(true);
        tela.getBotaoNotificaoes().setVisible(true);
    }
}
