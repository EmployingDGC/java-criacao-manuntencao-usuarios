package com.pss.presenter.painel_menu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.pss.presenter.PainelMenuPresenter;
import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.state.view.painel_menu.PainelMenuAdmState;

public class PainelMenuAdmPresenter extends PainelMenuPresenter {
    private ActionListener acaoDoBotaoAlterarSenha;
    private ActionListener acaoDoBotaoManterUsuario;

    public PainelMenuAdmPresenter(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter, new PainelMenuAdmState(telaPresenter));
        
        PainelMenuAdmPresenter thisObject = this;

        this.acaoDoBotaoManterUsuario = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.sairPainel();
                thisObject.getTelaPresenter().vaParaManterUsuario();
            }
        };
    
        this.acaoDoBotaoAlterarSenha = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.sairPainel();
                thisObject.getTelaPresenter().vaParaEditarAdministrador(null);
            }
        };
    }

    @Override
    public PainelMenuAdmState getEstado() {
        return (PainelMenuAdmState) super.getEstado();
    }

    public void aplicarEstado() {
        this.getEstado().setAcaoDoBotaoManterUsuario(this.acaoDoBotaoManterUsuario);
        this.getEstado().setAcaoDoBotaoAlterarSenha(this.acaoDoBotaoAlterarSenha);
        
        this.getEstado().aplicarEstado();
        
        this.getTelaPresenter().getTela().setPainelMeio(this.getPainel());
    }

    private void sairPainel() {
        this.getEstado().setAcaoDoBotaoManterUsuario(null);
        this.getEstado().setAcaoDoBotaoAlterarSenha(null);
    }
}
