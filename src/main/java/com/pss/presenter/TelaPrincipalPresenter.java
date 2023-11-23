package com.pss.presenter;

import com.pss.view.PainelFormulario;
import com.pss.view.Tela;

import com.pss.state.view.PainelFormularioState;

public class TelaPrincipalPresenter {
    private Tela tela;

    public TelaPrincipalPresenter(PainelFormularioState estadoInicial) {
        this.tela = new Tela();
        
        PainelFormulario pf = new PainelFormulario(this.tela, estadoInicial);

        this.tela.setPainelMeio(pf);
    }
}
