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
        
        this.painelFormularioEntrarPresenter = new PainelFormularioEntrarPresenter(this);
        this.painelFormularioRegistrarPresenter = new PainelFormularioRegistrarPresenter(this);

        this.painelFormularioEntrarPresenter.aplicarEstado();

        this.tela.setPainelMeio(this.painelFormulario);
    }

    public PainelFormulario getPainelFormulario() {
        return this.painelFormulario;
    }

    public PainelManterUsuarios getPainelManterUsuarios() {
        return this.painelManterUsuarios;
    }

    public Tela getTela() {
        return this.tela;
    }

    public void vaParaRegistrar() {
        this.painelFormularioRegistrarPresenter.aplicarEstado();
    }

    public void vaParaEntrar() {
        this.painelFormularioEntrarPresenter.aplicarEstado();
    }
}
