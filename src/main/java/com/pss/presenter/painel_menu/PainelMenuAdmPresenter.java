package com.pss.presenter.painel_menu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.pss.command.PainelMenuCommand;
import com.pss.presenter.PainelMenuPresenter;
import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.state.view.painel_menu.PainelMenuAdmState;

public class PainelMenuAdmPresenter extends PainelMenuPresenter {
    private ActionListener acaoDoBotaoAlterarSenha;
    private ActionListener acaoDoBotaoManterUsuario;
    private ActionListener acaoDoBotaoSair;

    public PainelMenuAdmPresenter(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter, new PainelMenuAdmState(telaPresenter));
        
        PainelMenuAdmPresenter thisObject = this;

        this.acaoDoBotaoManterUsuario = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PainelMenuCommand.carregarUsuarios(thisObject);
            }
        };
    
        this.acaoDoBotaoAlterarSenha = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.sairPainel();
                thisObject.getTelaPresenter().vaParaEditarAdministrador(thisObject.getTelaPresenter().getUsuarioLogado());
            }
        };
    
        this.acaoDoBotaoSair = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PainelMenuCommand.sair(telaPresenter);
                thisObject.sairPainel();
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
        this.getEstado().setAcaoDoBotaoSair(this.acaoDoBotaoSair);
        
        this.getEstado().aplicarEstado();
        
        this.getTelaPresenter().getTela().setPainelMeio(this.getPainel());
    }

    public void sairPainel() {
        this.getEstado().setAcaoDoBotaoManterUsuario(null);
        this.getEstado().setAcaoDoBotaoAlterarSenha(null);
        this.getEstado().setAcaoDoBotaoSair(null);
    }
}
