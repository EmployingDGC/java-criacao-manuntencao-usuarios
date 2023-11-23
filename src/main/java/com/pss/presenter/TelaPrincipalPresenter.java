package com.pss.presenter;

import com.pss.view.PainelManterUsuarios;
import com.pss.view.PainelFormulario;
import com.pss.view.Tela;

import com.pss.presenter.painel_formulario.PainelFormularioEntrarPresenter;
import com.pss.presenter.painel_formulario.PainelFormularioRegistrarPresenter;

public class TelaPrincipalPresenter {
    private Tela tela;

    private PainelFormulario painelFormulario;
    private PainelManterUsuarios painelManterUsuarios;

    private PainelFormularioEntrarPresenter painelFormularioEntrarPresenter;
    private PainelFormularioRegistrarPresenter painelFormularioRegistrarPresenter;

    public TelaPrincipalPresenter() {
        this.tela = new Tela();

        this.painelFormulario = new PainelFormulario(this.tela);
        
        this.painelFormularioEntrarPresenter = new PainelFormularioEntrarPresenter(this, this.painelFormulario);
        this.painelFormularioRegistrarPresenter = new PainelFormularioRegistrarPresenter(this, this.painelFormulario);

        this.painelFormularioEntrarPresenter.aplicarEstado();

        this.tela.setPainelMeio(this.painelFormulario);
    }

    public Tela getTela() {
        return this.tela;
    }

    public void vaParaRegistrar() {
        this.painelFormularioRegistrarPresenter.aplicarEstado();
    }
}
