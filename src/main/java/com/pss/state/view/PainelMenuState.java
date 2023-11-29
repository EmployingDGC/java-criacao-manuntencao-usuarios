package com.pss.state.view;

import com.pss.presenter.TelaPrincipalPresenter;
import com.pss.view.PainelMenu;

public class PainelMenuState {
    private TelaPrincipalPresenter telaPresenter;

    private PainelMenu painel;

    public PainelMenuState(TelaPrincipalPresenter telaPresenter) {
        this.telaPresenter = telaPresenter;
        this.painel = telaPresenter.getPainelMenu();
    }

    public void aplicarEstado() {
        this.painel.getTelaPresenter().getTela().setTitulo("Menu");

        this.painel.getBotaoManterUsuario().setVisible(false);
        this.painel.getBotaoAlterarSenha().setVisible(false);
    }

    public TelaPrincipalPresenter getTelaPresenter() {
        return this.telaPresenter;
    }
    
    public PainelMenu getPainel() {
        return this.painel;
    }

    public void setPainel(PainelMenu painel) {
        this.painel = painel;
    }
}
