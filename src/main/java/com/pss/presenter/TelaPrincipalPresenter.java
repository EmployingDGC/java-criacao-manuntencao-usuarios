package com.pss.presenter;

import com.pss.view.PainelManterUsuarios;
import com.pss.view.PainelFormulario;
import com.pss.view.PainelMenu;
import com.pss.view.Tela;

import com.pss.presenter.painel_formulario.PainelFormularioEditarUsuarioPresenter;
import com.pss.presenter.painel_formulario.PainelFormularioRegistrarPresenter;
import com.pss.presenter.painel_formulario.PainelFormularioEntrarPresenter;

import com.pss.presenter.painel_menu.PainelMenuUsuarioPresenter;
import com.pss.presenter.painel_menu.PainelMenuAdmPresenter;

import com.pss.state.view.tela.TelaAdministradorState;
import com.pss.state.view.tela.TelaSemUsuarioState;
import com.pss.state.view.tela.TelaUsuarioState;

public class TelaPrincipalPresenter {
    private Tela tela;

    private PainelManterUsuarios painelManterUsuarios;
    private PainelFormulario painelFormulario;
    private PainelMenu painelMenu;

    private PainelFormularioEditarUsuarioPresenter painelFormularioEditarUsuarioPresenter;
    private PainelFormularioRegistrarPresenter painelFormularioRegistrarPresenter;
    private PainelFormularioEntrarPresenter painelFormularioEntrarPresenter;

    private PainelMenuUsuarioPresenter painelMenuUsuarioPresenter;
    private PainelMenuAdmPresenter painelMenuAdmPresenter;

    private TelaAdministradorState telaAdministradorState;
    private TelaSemUsuarioState telaSemUsuarioState;
    private TelaUsuarioState telaUsuarioState;

    public TelaPrincipalPresenter() {
        this.tela = new Tela();

        this.painelManterUsuarios = new PainelManterUsuarios(this);
        this.painelFormulario = new PainelFormulario(this);
        this.painelMenu = new PainelMenu(this);
        
        this.painelFormularioEditarUsuarioPresenter = new PainelFormularioEditarUsuarioPresenter(this);
        this.painelFormularioRegistrarPresenter = new PainelFormularioRegistrarPresenter(this);
        this.painelFormularioEntrarPresenter = new PainelFormularioEntrarPresenter(this);

        this.painelMenuUsuarioPresenter = new PainelMenuUsuarioPresenter(this);
        this.painelMenuAdmPresenter = new PainelMenuAdmPresenter(this);

        this.telaAdministradorState = new TelaAdministradorState(this);
        this.telaSemUsuarioState = new TelaSemUsuarioState(this);
        this.telaUsuarioState = new TelaUsuarioState(this);

        this.setStateSemUsuario();
        
        this.vaParaEntrar();
    }

    public void revalidarTela() {
        this.tela.revalidate();
        this.tela.repaint();
    }

    public PainelManterUsuarios getPainelManterUsuarios() {
        return this.painelManterUsuarios;
    }

    public PainelFormulario getPainelFormulario() {
        return this.painelFormulario;
    }

    public PainelMenu getPainelMenu() {
        return this.painelMenu;
    }

    public Tela getTela() {
        return this.tela;
    }

    public void setStateAdministrador() {
        this.telaAdministradorState.aplicarEstado();
        this.revalidarTela();
    }
    
    public void setStateUsuario() {
        this.telaUsuarioState.aplicarEstado();
        this.revalidarTela();
    }

    public void setStateSemUsuario() {
        this.telaSemUsuarioState.aplicarEstado();
        this.revalidarTela();
    }

    public void vaParaRegistrar() {
        this.painelFormularioRegistrarPresenter.aplicarEstado();
        this.revalidarTela();
    }

    public void vaParaEntrar() {
        this.painelFormularioEntrarPresenter.aplicarEstado();
        this.revalidarTela();
    }

    public void vaParaMenuAdministrador() {
        this.painelMenuAdmPresenter.aplicarEstado();
        this.revalidarTela();
    }

    public void vaParaMenuUsuario() {
        this.painelMenuUsuarioPresenter.aplicarEstado();
        this.revalidarTela();
    }
    
    public void vaParaEditarUsuario() {
        this.painelFormularioEditarUsuarioPresenter.aplicarEstado();
        this.revalidarTela();
    }
}
