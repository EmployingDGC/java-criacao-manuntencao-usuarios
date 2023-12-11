package com.pss.presenter;

import com.pss.view.PainelManterUsuarios;
import com.pss.view.PainelFormulario;
import com.pss.view.PainelMenu;
import com.pss.view.Tela;

import com.pss.presenter.painel_formulario.PainelFormularioEditarUsuarioPresenter;
import com.pss.presenter.painel_manter_usuarios.PainelManterUsuariosAdmPresenter;
import com.pss.model.usuario.AdministradorModel;
import com.pss.model.usuario.UsuarioModel;
import com.pss.presenter.painel_formulario.PainelFormularioEditarAdmPresenter;
import com.pss.presenter.painel_formulario.PainelFormularioRegistrarPresenter;
import com.pss.presenter.painel_formulario.PainelFormularioEntrarPresenter;

import com.pss.presenter.painel_menu.PainelMenuUsuarioPresenter;
import com.pss.service.FiltrarMensagemService;
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
    private PainelFormularioEditarAdmPresenter painelFormularioEditarAdmPresenter;
    private PainelFormularioRegistrarPresenter painelFormularioRegistrarPresenter;
    private PainelFormularioEntrarPresenter painelFormularioEntrarPresenter;

    private PainelManterUsuariosAdmPresenter painelManterUsuariosAdmPresenter;
    private PainelMenuUsuarioPresenter painelMenuUsuarioPresenter;
    private PainelMenuAdmPresenter painelMenuAdmPresenter;

    private TelaAdministradorState telaAdministradorState;
    private TelaSemUsuarioState telaSemUsuarioState;
    private TelaUsuarioState telaUsuarioState;

    private UsuarioModel usuarioLogado;

    public TelaPrincipalPresenter() {
        this.tela = new Tela();

        this.painelManterUsuarios = new PainelManterUsuarios(this);
        this.painelFormulario = new PainelFormulario(this);
        this.painelMenu = new PainelMenu(this);
        
        this.painelFormularioEditarUsuarioPresenter = new PainelFormularioEditarUsuarioPresenter(this);
        this.painelFormularioEditarAdmPresenter = new PainelFormularioEditarAdmPresenter(this);
        this.painelFormularioRegistrarPresenter = new PainelFormularioRegistrarPresenter(this);
        this.painelFormularioEntrarPresenter = new PainelFormularioEntrarPresenter(this);

        this.painelManterUsuariosAdmPresenter = new PainelManterUsuariosAdmPresenter(this);
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
    
    public void vaParaEditarUsuario(int[] ids) {
        this.painelFormularioEditarUsuarioPresenter.aplicarEstado();
        this.revalidarTela();
    }
    
    public void vaParaManterUsuario() {
        this.painelManterUsuariosAdmPresenter.aplicarEstado();
        this.revalidarTela();
    }
    
    public void vaParaEditarAdministrador(UsuarioModel u) {
        this.painelFormularioEditarAdmPresenter.aplicarEstado();
        this.painelFormularioEditarAdmPresenter.setUsuario(u);
        this.revalidarTela();
    }

    public UsuarioModel getUsuarioLogado() {
        return this.usuarioLogado;
    }

    public void setUsuarioLogado(UsuarioModel usuarioLogado) {
        if (usuarioLogado.isAdministrador()) {
            this.setStateAdministrador();
            
            int solicitacoes = FiltrarMensagemService.porRemetente(
                ((AdministradorModel) usuarioLogado).getMensagensEnviadas(),
                usuarioLogado
            ).size();
            
            this.tela.setUsuarioInfo(String.format("%s (Administrador)", usuarioLogado.getUsuario()));
            this.tela.getBotaoSolicitacoes().setText(String.format("%d", solicitacoes));
            
            this.vaParaMenuAdministrador();
        } else {
            this.setStateUsuario();
            
            this.tela.setUsuarioInfo(String.format("%s (Usuário)", usuarioLogado.getUsuario()));
            
            this.vaParaMenuUsuario();
        }

        int notificacoes = FiltrarMensagemService.porRemetente(usuarioLogado.getMensagensRecebidas(), usuarioLogado).size();

        this.tela.getBotaoNotificaoes().setText(String.format("%d", notificacoes));

        this.usuarioLogado = usuarioLogado;
    }
}
