package com.pss.presenter.painel_formulario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.pss.presenter.PainelFormularioPresenter;
import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.state.view.painel_formulario.PainelFormularioEditarUsuarioState;

public class PainelFormularioEditarUsuarioPresenter extends PainelFormularioPresenter {
    private ActionListener acaoDoBotaoSalvar;
    private ActionListener acaoDoBotaoVoltar;

    public PainelFormularioEditarUsuarioPresenter(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter, new PainelFormularioEditarUsuarioState(telaPresenter));

        PainelFormularioEditarUsuarioPresenter thisObject = this;

        this.acaoDoBotaoSalvar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.sairPainel();
                thisObject.getTelaPresenter().vaParaMenuUsuario();
            }
        };

        this.acaoDoBotaoVoltar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.sairPainel();
                thisObject.getTelaPresenter().vaParaMenuUsuario();
            }
        };
    }

    @Override
    public PainelFormularioEditarUsuarioState getEstado() {
        return (PainelFormularioEditarUsuarioState) super.getEstado();
    }

    public void aplicarEstado() {
        this.getEstado().setAcaoDoBotaoSalvar(this.acaoDoBotaoSalvar);
        this.getEstado().setAcaoDoBotaoVoltar(this.acaoDoBotaoVoltar);

        this.getEstado().aplicarEstado();

        this.getTelaPresenter().getTela().setPainelMeio(this.getPainel());
    }

    private void sairPainel() {
        this.getEstado().setAcaoDoBotaoSalvar(null);
        this.getEstado().setAcaoDoBotaoVoltar(null);
    }
}
