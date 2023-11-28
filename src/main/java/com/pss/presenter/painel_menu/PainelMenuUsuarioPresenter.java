package com.pss.presenter.painel_menu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.pss.presenter.PainelMenuPresenter;
import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.state.view.painel_menu.PainelMenuUsuarioState;

public class PainelMenuUsuarioPresenter extends PainelMenuPresenter {
    private ActionListener acaoDoBotaoAlterarSenha;

    public PainelMenuUsuarioPresenter(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter, new PainelMenuUsuarioState(telaPresenter));
        
        PainelMenuUsuarioPresenter thisObject = this;
    
        this.acaoDoBotaoAlterarSenha = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.sairPainel();
                System.out.println("Alterando Senha (Usuário)");
                thisObject.getTelaPresenter().vaParaMenuUsuario();
            }
        };
    }

    @Override
    public PainelMenuUsuarioState getEstado() {
        return (PainelMenuUsuarioState) super.getEstado();
    }

    public void aplicarEstado() {
        this.getEstado().setAcaoDoBotaoAlterarSenha(this.acaoDoBotaoAlterarSenha);

        this.getEstado().aplicarEstado();

        this.getTelaPresenter().getTela().setPainelMeio(this.getPainel());
    }

    private void sairPainel() {
        this.getEstado().setAcaoDoBotaoAlterarSenha(null);
    }
}
