package com.pss.state.view;

import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.view.PainelFormulario;

public class PainelFormularioState {
    private TelaPrincipalPresenter telaPresenter;

    private PainelFormulario painel;

    public PainelFormularioState(TelaPrincipalPresenter telaPresenter) {
        this.telaPresenter = telaPresenter;
        this.painel = telaPresenter.getPainelFormulario();
    }

    public void aplicarEstado() {
        this.painel.getTelaPresenter().getTela().setTitulo(null);

        this.painel.getCheckBoxAdministrador().setVisible(false);
        
        this.painel.getScrollMensagem().setVisible(false);
        this.painel.getCampoMensagem().setEditable(true);
        this.painel.getLabelMensagem().setVisible(false);
        this.painel.getCampoMensagem().setText(null);
        
        this.painel.getCampoSenhaAtual().setEditable(true);
        this.painel.getCampoSenhaAtual().setVisible(false);
        this.painel.getLabelSenhaAtual().setVisible(false);
        this.painel.getCampoSenhaAtual().setText(null);
        
        this.painel.getCampoNovaSenha().setEditable(true);
        this.painel.getCampoNovaSenha().setVisible(false);
        this.painel.getLabelNovaSenha().setVisible(false);
        this.painel.getCampoNovaSenha().setText(null);
        
        this.painel.getCampoUsuario().setEditable(true);
        this.painel.getCampoUsuario().setVisible(false);
        this.painel.getLabelUsuario().setVisible(false);
        this.painel.getCampoUsuario().setText(null);
        
        this.painel.getCampoSenha().setEditable(true);
        this.painel.getCampoSenha().setVisible(false);
        this.painel.getLabelSenha().setVisible(false);
        this.painel.getCampoSenha().setText(null);
        
        this.painel.getCampoNome().setEditable(true);
        this.painel.getCampoNome().setVisible(false);
        this.painel.getLabelNome().setVisible(false);
        this.painel.getCampoNome().setText(null);
        
        this.painel.getBotaoRegistrar().setVisible(false);
        this.painel.getBotaoEntrar().setVisible(false);
        this.painel.getBotaoEnviar().setVisible(false);
        this.painel.getBotaoSalvar().setVisible(false);
        this.painel.getBotaoVoltar().setVisible(false);
    }

    public TelaPrincipalPresenter getTelaPresenter() {
        return this.telaPresenter;
    }
    
    public PainelFormulario getPainel() {
        return this.painel;
    }

    public void setPainel(PainelFormulario painel) {
        this.painel = painel;
    }
}
