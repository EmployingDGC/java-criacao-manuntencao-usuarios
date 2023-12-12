package com.pss.presenter.painel_manter_usuarios;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import com.pss.command.ManterUsuarioCommand;
import com.pss.model.usuario.UsuarioModel;
import com.pss.presenter.PainelManterUsuariosPresenter;
import com.pss.presenter.TelaPrincipalPresenter;

import com.pss.state.view.painel_manter_usuarios.PainelManterUsuariosAdmState;

public class PainelManterUsuariosAdmPresenter extends PainelManterUsuariosPresenter {
    private ActionListener acaoDoBotaoPesquisar;
    private ActionListener acaoDoBotaoNotificar;
    private ActionListener acaoDoBotaoExcluir;
    private ActionListener acaoDoBotaoEditar;
    private ActionListener acaoDoBotaoVoltar;

    private List<UsuarioModel> usuarios;

    public PainelManterUsuariosAdmPresenter(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter, new PainelManterUsuariosAdmState(telaPresenter));

        PainelManterUsuariosAdmPresenter thisObject = this;

        this.acaoDoBotaoPesquisar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.sairPainel();
                thisObject.getTelaPresenter().vaParaMenuAdministrador();
            }
        };

        this.acaoDoBotaoNotificar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.sairPainel();
                thisObject.getTelaPresenter().vaParaMenuAdministrador();
            }
        };

        this.acaoDoBotaoExcluir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManterUsuarioCommand.excluirUsuario(thisObject);
            }
        };

        this.acaoDoBotaoEditar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManterUsuarioCommand.editarUsuario(thisObject);
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
    public PainelManterUsuariosAdmState getEstado() {
        return (PainelManterUsuariosAdmState) super.getEstado();
    }

    public void aplicarEstado() {
        this.getEstado().setAcaoDoBotaoPesquisar(this.acaoDoBotaoPesquisar);
        this.getEstado().setAcaoDoBotaoNotificar(this.acaoDoBotaoNotificar);
        this.getEstado().setAcaoDoBotaoExcluir(this.acaoDoBotaoExcluir);
        this.getEstado().setAcaoDoBotaoEditar(this.acaoDoBotaoEditar);
        this.getEstado().setAcaoDoBotaoVoltar(this.acaoDoBotaoVoltar);

        this.getEstado().aplicarEstado();

        this.getTelaPresenter().getTela().setPainelMeio(this.getPainel());
    }

    public void setUsuarios(List<UsuarioModel> usuarios) {
        this.usuarios = usuarios;
    }

    public List<UsuarioModel> getUsuarios() {
        return this.usuarios;
    }

    public void sairPainel() {
        this.getEstado().setAcaoDoBotaoPesquisar(null);
        this.getEstado().setAcaoDoBotaoNotificar(null);
        this.getEstado().setAcaoDoBotaoExcluir(null);
        this.getEstado().setAcaoDoBotaoEditar(null);
        this.getEstado().setAcaoDoBotaoVoltar(null);
        
        this.getPainel().limparSelecaoDasLinhas();
    }
}
