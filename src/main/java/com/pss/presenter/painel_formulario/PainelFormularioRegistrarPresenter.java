package com.pss.presenter.painel_formulario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.pss.view.PainelFormulario;
import com.pss.presenter.PainelFormularioPresenter;
import com.pss.presenter.TelaPrincipalPresenter;
import com.pss.state.view.painel_formulario.PainelFormularioRegistrarState;

public class PainelFormularioRegistrarPresenter extends PainelFormularioPresenter {
    private ActionListener acaoDoBotaoRegistrar;
    private ActionListener acaoDoBotaoEntrar;

    public PainelFormularioRegistrarPresenter(TelaPrincipalPresenter telaPresenter, PainelFormulario painel) {
        super(telaPresenter, painel, new PainelFormularioRegistrarState(painel));

        this.acaoDoBotaoRegistrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão Registrar - Painel Registrar");
            }
        };

        this.acaoDoBotaoEntrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão Entrar - Painel Registrar");
            }
        };
    }

    public void aplicarEstado() {
        PainelFormularioRegistrarState estado = (PainelFormularioRegistrarState) this.getEstado();
        
        estado.setAcaoDoBotaoRegistrar(this.acaoDoBotaoRegistrar);
        estado.setAcaoDoBotaoEntrar(this.acaoDoBotaoEntrar);

        estado.aplicarEstado();
    }
}
