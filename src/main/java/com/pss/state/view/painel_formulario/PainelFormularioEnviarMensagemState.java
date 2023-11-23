package com.pss.state.view.painel_formulario;

import com.pss.state.view.PainelFormularioState;

import com.pss.view.PainelFormulario;

public class PainelFormularioEnviarMensagemState extends PainelFormularioState{
    public PainelFormularioEnviarMensagemState(PainelFormulario painel) {
        super(painel);
    }

    @Override
    public void aplicarEstado() {
        super.aplicarEstado();

        PainelFormulario pf = this.getPainel();

        pf.getTela().setTitulo("Enviar Mensagem");

        pf.getScrollMensagem().setVisible(true);

        pf.getCampoUsuario().setVisible(true);
        pf.getCampoNome().setVisible(true);
        
        pf.getCampoUsuario().setEditable(false);
        pf.getCampoNome().setEditable(false);

        pf.getLabelMensagem().setVisible(true);
        pf.getLabelUsuario().setVisible(true);
        pf.getLabelNome().setVisible(true);

        pf.getBotaoEnviar().setVisible(true);
        pf.getBotaoVoltar().setVisible(true);

        pf.revalidate();
    }
}
