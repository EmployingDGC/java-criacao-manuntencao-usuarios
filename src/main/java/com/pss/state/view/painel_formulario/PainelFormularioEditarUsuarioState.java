package com.pss.state.view.painel_formulario;

import com.pss.state.view.PainelFormularioState;

import com.pss.view.PainelFormulario;

public class PainelFormularioEditarUsuarioState extends PainelFormularioState {
    @Override
    public void aplicarEstado() {
        super.aplicarEstado();

        PainelFormulario pf = this.getPainelFormulario();

        pf.getTela().setTitulo("Editar Usuário");

        pf.getCampoSenhaAtual().setVisible(true);
        pf.getCampoNovaSenha().setVisible(true);
        pf.getCampoUsuario().setVisible(true);
        pf.getCampoNome().setVisible(true);
        
        pf.getCampoUsuario().setEditable(false);

        pf.getLabelSenhaAtual().setVisible(true);
        pf.getLabelNovaSenha().setVisible(true);
        pf.getLabelUsuario().setVisible(true);
        pf.getLabelNome().setVisible(true);

        pf.getBotaoSalvar().setVisible(true);
        pf.getBotaoVoltar().setVisible(true);

        pf.revalidate();
    }
}
