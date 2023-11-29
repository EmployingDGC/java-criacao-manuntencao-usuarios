package com.pss.state.view;

import javax.swing.JPanel;

import com.pss.presenter.TelaPrincipalPresenter;

public class TelaState {
    private final JPanel PAINEL_VAZIO = new JPanel();

    private TelaPrincipalPresenter telaPresenter;

    public TelaState(TelaPrincipalPresenter telaPresenter) {
        this.telaPresenter = telaPresenter;
    }

    public void aplicarEstado() {
        this.telaPresenter.getTela().setUsuarioInfo(null);
        this.telaPresenter.getTela().setTitulo(null);

        this.telaPresenter.getTela().getBotaoSolicitacoes().setVisible(false);
        this.telaPresenter.getTela().getBotaoNotificaoes().setVisible(false);

        this.telaPresenter.getTela().setPainelMeio(PAINEL_VAZIO);
    }

    public TelaPrincipalPresenter getTelaPresenter() {
        return this.telaPresenter;
    }
}
