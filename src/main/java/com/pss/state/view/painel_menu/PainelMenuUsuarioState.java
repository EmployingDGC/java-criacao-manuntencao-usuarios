package com.pss.state.view.painel_menu;

import java.awt.event.ActionListener;

import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.state.view.PainelMenuState;
import com.pss.view.PainelMenu;

public class PainelMenuUsuarioState extends PainelMenuState {
    private ActionListener acaoDoBotaoAlterarSenha;

    public PainelMenuUsuarioState(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter);
    }

    @Override
    public void aplicarEstado() {
        super.aplicarEstado();

        PainelMenu pm = this.getPainel();

        pm.getBotaoAlterarSenha().setVisible(true);

        pm.revalidate();
    }
    
    public void setAcaoDoBotaoAlterarSenha(ActionListener acao) {
        if (this.acaoDoBotaoAlterarSenha != null) {
            this.getPainel().getBotaoAlterarSenha().removeActionListener(this.acaoDoBotaoAlterarSenha);
        }

        this.getPainel().getBotaoAlterarSenha().addActionListener(acao);
        this.acaoDoBotaoAlterarSenha = acao;
    }
}
