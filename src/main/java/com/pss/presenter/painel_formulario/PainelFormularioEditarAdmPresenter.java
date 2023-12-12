package com.pss.presenter.painel_formulario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.pss.command.PainelFormularioCommand;
import com.pss.model.usuario.UsuarioModel;
import com.pss.presenter.PainelFormularioPresenter;
import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.state.view.painel_formulario.PainelFormularioEditarAdmState;

public class PainelFormularioEditarAdmPresenter extends PainelFormularioPresenter {
    private ActionListener acaoDoBotaoSalvar;
    private ActionListener acaoDoBotaoVoltar;

    private UsuarioModel usuario;

    public PainelFormularioEditarAdmPresenter(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter, new PainelFormularioEditarAdmState(telaPresenter));

        PainelFormularioEditarAdmPresenter thisObject = this;

        this.acaoDoBotaoSalvar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PainelFormularioCommand.salvarAlteracoesUsuario(thisObject);
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

    public UsuarioModel getUsuario() {
        return this.usuario;
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

    public void setUsuario(UsuarioModel usuario) {
        this.getEstado().getPainel().getCampoUsuario().setText(usuario.getUsuario());
        this.getEstado().getPainel().getCampoSenha().setText(usuario.getSenha());
        this.getEstado().getPainel().getCampoNome().setText(usuario.getNome());

        this.usuario = usuario;
    }

    public void sairPainel() {
        this.usuario = null;
        this.getEstado().setAcaoDoBotaoSalvar(null);
        this.getEstado().setAcaoDoBotaoVoltar(null);
    }
}
