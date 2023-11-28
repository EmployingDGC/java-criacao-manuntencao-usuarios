package com.pss.state.view.painel_manter_usuarios;

import java.awt.event.ActionListener;

import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.state.view.PainelManterUsuariosState;

public class PainelManterUsuariosAdmState extends PainelManterUsuariosState {
    private ActionListener acaoDoBotaoPesquisar;
    private ActionListener acaoDoBotaoNotificar;
    private ActionListener acaoDoBotaoExcluir;
    private ActionListener acaoDoBotaoEditar;
    private ActionListener acaoDoBotaoVoltar;

    public PainelManterUsuariosAdmState(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter);
    }

    @Override
    public void aplicarEstado() {
        super.aplicarEstado();
    }

    public void setAcaoDoBotaoPesquisar(ActionListener acao) {
        if (this.acaoDoBotaoPesquisar != null) {
            this.getPainel().getBotaoPesquisar().removeActionListener(this.acaoDoBotaoPesquisar);
        }
        
        this.getPainel().getBotaoPesquisar().addActionListener(acao);
        this.acaoDoBotaoPesquisar = acao;
    }

    public void setAcaoDoBotaoNotificar(ActionListener acao) {
        if (this.acaoDoBotaoNotificar != null) {
            this.getPainel().getBotaoNotificar().removeActionListener(this.acaoDoBotaoNotificar);
        }
        
        this.getPainel().getBotaoNotificar().addActionListener(acao);
        this.acaoDoBotaoNotificar = acao;
    }
    
    public void setAcaoDoBotaoExcluir(ActionListener acao) {
        if (this.acaoDoBotaoExcluir != null) {
            this.getPainel().getBotaoExcluir().removeActionListener(this.acaoDoBotaoExcluir);
        }

        this.getPainel().getBotaoExcluir().addActionListener(acao);
        this.acaoDoBotaoExcluir = acao;
    }

    public void setAcaoDoBotaoEditar(ActionListener acao) {
        if (this.acaoDoBotaoEditar != null) {
            this.getPainel().getBotaoEditar().removeActionListener(this.acaoDoBotaoEditar);
        }
        
        this.getPainel().getBotaoEditar().addActionListener(acao);
        this.acaoDoBotaoEditar = acao;
    }
    
    public void setAcaoDoBotaoVoltar(ActionListener acao) {
        if (this.acaoDoBotaoVoltar != null) {
            this.getPainel().getBotaoVoltar().removeActionListener(this.acaoDoBotaoVoltar);
        }

        this.getPainel().getBotaoVoltar().addActionListener(acao);
        this.acaoDoBotaoVoltar = acao;
    }
}
