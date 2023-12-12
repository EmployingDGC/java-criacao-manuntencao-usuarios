package com.pss.command;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.pss.collection.UsuarioCollection;
import com.pss.model.MensagemModel;
import com.pss.model.usuario.UsuarioModel;
import com.pss.presenter.TelaPrincipalPresenter;
import com.pss.presenter.painel_menu.PainelMenuAdmPresenter;
import com.pss.service.FiltrarMensagemService;
import com.pss.view.PainelManterUsuarios;

public class PainelMenuCommand {
    
    static public void carregarUsuarios(PainelMenuAdmPresenter presenter) {
        List<UsuarioModel> usuarios = UsuarioCollection.getInstancia().getUsuarios();
        UsuarioModel usuarioLogado = presenter.getTelaPresenter().getUsuarioLogado();

        PainelManterUsuarios painel = presenter.getTelaPresenter().getPainelManterUsuarios();

        List<UsuarioModel> usuariosFiltrados = new ArrayList<UsuarioModel>();

        painel.removerTodasAsLinhas();

        for (UsuarioModel u : usuarios) {
            if (u == usuarioLogado) {
                continue;
            }

            List<MensagemModel> msgRecebidas = u.getMensagensRecebidas();
            List<MensagemModel> msgLidas = FiltrarMensagemService.lida(msgRecebidas);

            painel.addLinha(
                u.getNome(),
                u.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                String.valueOf(msgRecebidas.size()),
                String.valueOf(msgLidas.size())
            );

            usuariosFiltrados.add(u);
        }

        presenter.sairPainel();
        presenter.getTelaPresenter().vaParaManterUsuario(usuariosFiltrados);
    }

    static public void sair(TelaPrincipalPresenter presenter) {
        presenter.setStateSemUsuario();
        presenter.vaParaEntrar();
    }
}
