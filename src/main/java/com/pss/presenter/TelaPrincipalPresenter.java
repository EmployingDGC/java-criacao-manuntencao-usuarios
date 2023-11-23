package com.pss.presenter;

import com.pss.view.PainelFormulario;
import com.pss.view.Tela;

import com.pss.state.view.PainelFormularioState;
import com.pss.state.view.painel_formulario.PainelFormularioEntrarState;

public class TelaPrincipalPresenter {
    private Tela tela;

    public TelaPrincipalPresenter() {
        this.tela = new Tela();

        PainelFormularioState estadoInicial = new PainelFormularioEntrarState();
        
        PainelFormulario pf = new PainelFormulario(this.tela, estadoInicial);

        this.tela.setPainelMeio(pf);
    }
}
