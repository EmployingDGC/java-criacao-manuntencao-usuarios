package com.pss.presenter.painel_formulario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.pss.presenter.PainelFormularioPresenter;
import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.state.view.painel_formulario.PainelFormularioEntrarState;
import com.pss.view.Tela;

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
                thisObject.sairPainel();

                Tela t = thisObject.getTelaPresenter().getTela();

                // thisObject.getTelaPresenter().setStateAdministrador();

                // t.setUsuarioInfo("Fulano de Tal (Administrador)");
                // t.getBotaoNotificaoes().setText("1");
                // t.getBotaoSolicitacoes().setText("1");

                // thisObject.getTelaPresenter().vaParaMenuAdministrador();

                thisObject.getTelaPresenter().setStateUsuario();

                t.setUsuarioInfo("Fulano de Tal (Usuário)");
                t.getBotaoNotificaoes().setText("1");

                thisObject.getTelaPresenter().vaParaMenuUsuario();
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

    private void sairPainel() {
        this.getEstado().setAcaoDoBotaoRegistrar(null);
        this.getEstado().setAcaoDoBotaoEntrar(null);
    }
}
