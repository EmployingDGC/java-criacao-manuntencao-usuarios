package com.pss.state.view.painel_formulario;

import com.pss.state.view.PainelFormularioState;

import com.pss.view.PainelFormulario;

public class PainelFormularioEditarUsuarioAdmState extends PainelFormularioState {
    @Override
    public void aplicarEstado() {
        super.aplicarEstado();

        PainelFormulario pf = this.getPainelFormulario();

        pf.getTela().setTitulo("Editar Usuário");

        pf.getCampoUsuario().setVisible(true);
        pf.getCampoSenha().setVisible(true);
        pf.getCampoNome().setVisible(true);

        pf.getLabelUsuario().setVisible(true);
        pf.getLabelSenha().setVisible(true);
        pf.getLabelNome().setVisible(true);

        pf.getBotaoSalvar().setVisible(true);
        pf.getBotaoVoltar().setVisible(true);

        pf.getCheckBoxAdministrador().setVisible(true);

        pf.revalidate();
    }
}
