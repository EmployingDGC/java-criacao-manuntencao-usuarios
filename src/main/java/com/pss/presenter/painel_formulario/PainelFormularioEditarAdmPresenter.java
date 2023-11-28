package com.pss.presenter.painel_formulario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.pss.presenter.PainelFormularioPresenter;
import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.state.view.painel_formulario.PainelFormularioEditarAdmState;

public class PainelFormularioEditarAdmPresenter extends PainelFormularioPresenter {
    private ActionListener acaoDoBotaoSalvar;
    private ActionListener acaoDoBotaoVoltar;

    public PainelFormularioEditarAdmPresenter(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter, new PainelFormularioEditarAdmState(telaPresenter));

        PainelFormularioEditarAdmPresenter thisObject = this;

        this.acaoDoBotaoSalvar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.sairPainel();
                thisObject.getTelaPresenter().vaParaMenuAdministrador();
            }
        };

        this.acaoDoBotaoVoltar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.sairPainel();
                thisObject.getTelaPresenter().vaParaMenuAdministrador();
            }
        };
    }

    @Override
    public PainelFormularioEditarAdmState getEstado() {
        return (PainelFormularioEditarAdmState) super.getEstado();
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
