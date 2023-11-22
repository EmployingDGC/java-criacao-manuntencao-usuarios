package com.pss.state.view.painel_formulario;

import com.pss.state.view.PainelFormularioState;
import com.pss.view.PainelFormulario;

public class PainelFormularioEntrarState extends PainelFormularioState {
    @Override
    public void aplicarEstado() {
        super.aplicarEstado();

        PainelFormulario pf = this.getPainelFormulario();

        pf.getTela().setTitulo("Entrar");

        pf.getCampoUsuario().setVisible(true);
        pf.getCampoSenha().setVisible(true);

        pf.getLabelUsuario().setVisible(true);
        pf.getLabelSenha().setVisible(true);

        pf.getBotaoRegistrar().setVisible(true);
        pf.getBotaoEntrar().setVisible(true);

        pf.revalidate();
    }
}
