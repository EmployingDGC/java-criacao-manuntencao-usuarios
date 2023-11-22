package com.pss.state.view;

import com.pss.view.PainelFormulario;

public class PainelFormularioState {
    private PainelFormulario painelFormulario;

    public void aplicarEstado() {
        this.painelFormulario.getTela().setTitulo(null);

        this.painelFormulario.getCheckBoxAdministrador().setVisible(false);
        
        this.painelFormulario.getScrollMensagem().setVisible(false);
        this.painelFormulario.getLabelMensagem().setVisible(false);
        this.painelFormulario.getCampoMensagem().setText(null);
        
        this.painelFormulario.getCampoSenhaAtual().setVisible(false);
        this.painelFormulario.getLabelSenhaAtual().setVisible(false);
        this.painelFormulario.getCampoSenhaAtual().setText(null);
        
        this.painelFormulario.getCampoNovaSenha().setVisible(false);
        this.painelFormulario.getLabelNovaSenha().setVisible(false);
        this.painelFormulario.getCampoNovaSenha().setText(null);
        
        this.painelFormulario.getCampoUsuario().setVisible(false);
        this.painelFormulario.getLabelUsuario().setVisible(false);
        this.painelFormulario.getCampoUsuario().setText(null);
        
        this.painelFormulario.getCampoSenha().setVisible(false);
        this.painelFormulario.getLabelSenha().setVisible(false);
        this.painelFormulario.getCampoSenha().setText(null);
        
        this.painelFormulario.getCampoNome().setVisible(false);
        this.painelFormulario.getLabelNome().setVisible(false);
        this.painelFormulario.getCampoNome().setText(null);
        
        this.painelFormulario.getBotaoRegistrar().setVisible(false);
        this.painelFormulario.getBotaoEntrar().setVisible(false);
        this.painelFormulario.getBotaoEnviar().setVisible(false);
        this.painelFormulario.getBotaoSalvar().setVisible(false);
        this.painelFormulario.getBotaoVoltar().setVisible(false);
    }
    
    public PainelFormulario getPainelFormulario() {
        return this.painelFormulario;
    }

    public void setPainelFormulario(PainelFormulario painelFormulario) {
        this.painelFormulario = painelFormulario;
    }
}
