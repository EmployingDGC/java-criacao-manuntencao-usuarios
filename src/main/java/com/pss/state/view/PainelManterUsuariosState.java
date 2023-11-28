package com.pss.state.view;

import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.view.PainelManterUsuarios;

public class PainelManterUsuariosState {
    private TelaPrincipalPresenter telaPresenter;

    private PainelManterUsuarios painel;

    public PainelManterUsuariosState(TelaPrincipalPresenter telaPresenter) {
        this.telaPresenter = telaPresenter;
        this.painel = telaPresenter.getPainelManterUsuarios();
    }

    public void aplicarEstado() {
        this.painel.getTelaPresenter().getTela().setTitulo("Manter Usuários");

        this.painel.getBotaoPesquisar().setVisible(true);
        this.painel.getBotaoNotificar().setVisible(true);
        this.painel.getBotaoExcluir().setVisible(true);
        this.painel.getBotaoVoltar().setVisible(true);
        this.painel.getBotaoEditar().setVisible(true);
        
        this.painel.getCampoPesquisa().setVisible(true);
    }

    public TelaPrincipalPresenter getTelaPresenter() {
        return this.telaPresenter;
    }
    
    public PainelManterUsuarios getPainel() {
        return this.painel;
    }

    public void setPainel(PainelManterUsuarios painel) {
        this.painel = painel;
    }
}
