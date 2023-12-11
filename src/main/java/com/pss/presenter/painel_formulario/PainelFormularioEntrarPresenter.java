package com.pss.presenter.painel_formulario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.pss.command.PainelFormularioCommand;
import com.pss.presenter.PainelFormularioPresenter;
import com.pss.presenter.TelaPrincipalPresenter;
import com.pss.state.view.painel_formulario.PainelFormularioEntrarState;

public class PainelFormularioEntrarPresenter extends PainelFormularioPresenter {
    private ActionListener acaoDoBotaoRegistrar;
    private ActionListener acaoDoBotaoEntrar;

    public PainelFormularioEntrarPresenter(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter, new PainelFormularioEntrarState(telaPresenter));

        PainelFormularioEntrarPresenter thisObject = this;

        this.acaoDoBotaoRegistrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.sairPainel();
                thisObject.getTelaPresenter().vaParaRegistrar();
            }
        };

        this.acaoDoBotaoEntrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PainelFormularioCommand.logarUsuario(thisObject);
            }
        };
    }

    @Override
    public PainelFormularioEntrarState getEstado() {
        return (PainelFormularioEntrarState) super.getEstado();
    }

    public void aplicarEstado() {
        this.getEstado().setAcaoDoBotaoRegistrar(this.acaoDoBotaoRegistrar);
        this.getEstado().setAcaoDoBotaoEntrar(this.acaoDoBotaoEntrar);

        this.getEstado().aplicarEstado();

        this.getTelaPresenter().getTela().setPainelMeio(this.getPainel());
    }

    public void sairPainel() {
        this.getEstado().setAcaoDoBotaoRegistrar(null);
        this.getEstado().setAcaoDoBotaoEntrar(null);
    }
}
