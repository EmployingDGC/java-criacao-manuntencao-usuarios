package com.pss.state.view;

import com.pss.view.PainelFormulario;

public class PainelFormularioState {
    private PainelFormulario painelFormulario;

    public PainelFormularioState(PainelFormulario painelFormulario) {
        this.painelFormulario = painelFormulario;
    }

    public void setEstado() {
        this.painelFormulario.getCheckBoxAdministrador().setVisible(false);

        this.painelFormulario.getCampoSenhaAtual().setVisible(false);
        this.painelFormulario.getCampoNovaSenha().setVisible(false);
        this.painelFormulario.getCampoMensagem().setVisible(false);
        this.painelFormulario.getCampoUsuario().setVisible(false);
        this.painelFormulario.getCampoSenha().setVisible(false);
        this.painelFormulario.getCampoNome().setVisible(false);
        
        this.painelFormulario.getBotaoRegistrar().setVisible(false);
        this.painelFormulario.getBotaoEntrar().setVisible(false);
        this.painelFormulario.getBotaoEnviar().setVisible(false);
        this.painelFormulario.getBotaoSalvar().setVisible(false);
        this.painelFormulario.getBotaoVoltar().setVisible(false);
    }

    public PainelFormulario getPainelFormulario() {
        return this.painelFormulario;
    }
}
