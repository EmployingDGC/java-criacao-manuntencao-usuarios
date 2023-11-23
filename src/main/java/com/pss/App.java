package com.pss;

import com.pss.presenter.TelaPrincipalPresenter;
import com.pss.state.view.painel_formulario.PainelFormularioEntrarState;

public final class App {
    public static void main(String[] args) {
        new TelaPrincipalPresenter(new PainelFormularioEntrarState());
    }
}
