package com.pss.state.view.painel_formulario;

import com.pss.state.view.PainelFormularioState;

import com.pss.view.PainelFormulario;

public class PainelFormularioRegistrarState extends PainelFormularioState {
    @Override
    public void aplicarEstado() {
        super.aplicarEstado();

        PainelFormulario pf = this.getPainelFormulario();

        pf.getTela().setTitulo("Registrar");

        pf.getCampoUsuario().setVisible(true);
        pf.getCampoSenha().setVisible(true);
        pf.getCampoNome().setVisible(true);

        pf.getLabelUsuario().setVisible(true);
        pf.getLabelSenha().setVisible(true);
        pf.getLabelNome().setVisible(true);

        pf.getBotaoRegistrar().setVisible(true);
        pf.getBotaoEntrar().setVisible(true);

        pf.revalidate();
    }
}
