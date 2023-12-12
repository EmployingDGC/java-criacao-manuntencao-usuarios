package com.pss.state.view.painel_menu;

import java.awt.event.ActionListener;

import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.state.view.PainelMenuState;
import com.pss.view.PainelMenu;

public class PainelMenuAdmState extends PainelMenuState {
    private ActionListener acaoDoBotaoManterUsuario;
    private ActionListener acaoDoBotaoAlterarSenha;
    private ActionListener acaoDoBotaoSair;

    public PainelMenuAdmState(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter);
    }

    @Override
    public void aplicarEstado() {
        super.aplicarEstado();

        PainelMenu pm = this.getPainel();

        pm.getBotaoManterUsuario().setVisible(true);
        pm.getBotaoAlterarSenha().setVisible(true);
        pm.getBotaoSair().setVisible(true);
    }

    public void setAcaoDoBotaoManterUsuario(ActionListener acao) {
        if (this.acaoDoBotaoManterUsuario != null) {
            this.getPainel().getBotaoManterUsuario().removeActionListener(this.acaoDoBotaoManterUsuario);
        }
        
        this.getPainel().getBotaoManterUsuario().addActionListener(acao);
        this.acaoDoBotaoManterUsuario = acao;
    }
    
    public void setAcaoDoBotaoAlterarSenha(ActionListener acao) {
        if (this.acaoDoBotaoAlterarSenha != null) {
            this.getPainel().getBotaoAlterarSenha().removeActionListener(this.acaoDoBotaoAlterarSenha);
        }

        this.getPainel().getBotaoAlterarSenha().addActionListener(acao);
        this.acaoDoBotaoAlterarSenha = acao;
    }
    
    public void setAcaoDoBotaoSair(ActionListener acao) {
        if (this.acaoDoBotaoSair != null) {
            this.getPainel().getBotaoSair().removeActionListener(this.acaoDoBotaoSair);
        }

        this.getPainel().getBotaoSair().addActionListener(acao);
        this.acaoDoBotaoSair = acao;
    }
}
