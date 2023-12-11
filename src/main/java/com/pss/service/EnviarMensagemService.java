package com.pss.service;

import com.pss.collection.MensagemCollection;
import com.pss.collection.UsuarioCollection;

import com.pss.model.MensagemModel;
import com.pss.model.TipoMensagemModel;
import com.pss.model.usuario.AdministradorModel;
import com.pss.model.usuario.UsuarioModel;

public class EnviarMensagemService {
    static public UsuarioModel solicitacaoCadastro(String nome, String usuario, String senha) {
        UsuarioModel u = new UsuarioModel(nome, usuario, senha);
        UsuarioCollection.getInstancia().add(u);

        AdministradorModel adm = FiltrarUsuarioService.usuarioAdministrador().get(0);

        MensagemModel m = new MensagemModel(
            String.format("O usuário `%s` está solicitando um novo cadastro", u.getUsuario()),
            u, adm, TipoMensagemModel.SOLICITACAO_DE_CADASTRO
        );

        MensagemCollection.getInstancia().add(m);

        m.enviar();

        return u;
    }

    static public MensagemModel comum(UsuarioModel remetente, UsuarioModel destinatario, String mensagem) {
        MensagemModel m = new MensagemModel(mensagem, remetente, destinatario, TipoMensagemModel.COMUM);

        MensagemCollection.getInstancia().add(m);

        m.enviar();

        return m;
    }
}
