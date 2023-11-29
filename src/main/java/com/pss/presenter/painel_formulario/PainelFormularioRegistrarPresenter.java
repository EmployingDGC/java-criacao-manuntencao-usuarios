package com.pss.presenter.painel_formulario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.pss.presenter.PainelFormularioPresenter;
import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.state.view.painel_formulario.PainelFormularioRegistrarState;

public class PainelFormularioRegistrarPresenter extends PainelFormularioPresenter {
    private ActionListener acaoDoBotaoRegistrar;
    private ActionListener acaoDoBotaoEntrar;

    public PainelFormularioRegistrarPresenter(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter, new PainelFormularioRegistrarState(telaPresenter));

        PainelFormularioRegistrarPresenter thisObject = this;

        this.acaoDoBotaoRegistrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.sairPainel();
                thisObject.getTelaPresenter().vaParaEntrar();
                System.out.println("Registrou");
            }
        };

        this.acaoDoBotaoEntrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.sairPainel();
                thisObject.getTelaPresenter().vaParaEntrar();
            }
        };
    }

    @Override
    public PainelFormularioRegistrarState getEstado() {
        return (PainelFormularioRegistrarState) super.getEstado();
    }

    public void aplicarEstado() {
        this.getEstado().setAcaoDoBotaoRegistrar(this.acaoDoBotaoRegistrar);
        this.getEstado().setAcaoDoBotaoEntrar(this.acaoDoBotaoEntrar);

        this.getEstado().aplicarEstado();

        this.getTelaPresenter().getTela().setPainelMeio(this.getPainel());
    }

    private void sairPainel() {
        this.getEstado().setAcaoDoBotaoRegistrar(null);
        this.getEstado().setAcaoDoBotaoEntrar(null);
    }
}
