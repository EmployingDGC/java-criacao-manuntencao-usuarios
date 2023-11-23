package com.pss.presenter.painel_formulario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.pss.view.PainelFormulario;
import com.pss.presenter.PainelFormularioPresenter;
import com.pss.presenter.TelaPrincipalPresenter;
import com.pss.state.view.painel_formulario.PainelFormularioEntrarState;

public class PainelFormularioEntrarPresenter extends PainelFormularioPresenter {
    private ActionListener acaoDoBotaoRegistrar;
    private ActionListener acaoDoBotaoEntrar;

    public PainelFormularioEntrarPresenter(TelaPrincipalPresenter telaPresenter, PainelFormulario painel) {
        super(telaPresenter, painel, new PainelFormularioEntrarState(painel));

        PainelFormularioEntrarPresenter thisObject = this;

        this.acaoDoBotaoRegistrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.getTelaPresenter().vaParaRegistrar();
            }
        };

        this.acaoDoBotaoEntrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão Entrar - Painel Entrar");
            }
        };
    }

    public void aplicarEstado() {
        PainelFormularioEntrarState estado = (PainelFormularioEntrarState) this.getEstado();
        
        estado.setAcaoDoBotaoRegistrar(this.acaoDoBotaoRegistrar);
        estado.setAcaoDoBotaoEntrar(this.acaoDoBotaoEntrar);

        estado.aplicarEstado();
    }
}
