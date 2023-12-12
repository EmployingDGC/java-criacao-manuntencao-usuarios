package com.pss.service;

import com.pss.collection.UsuarioCollection;
import com.pss.error.usuario.UsuarioObrigatorioError;
import com.pss.model.usuario.UsuarioModel;

public class AutenticarUsuarioService {
    static public void aprovarCadastro(UsuarioModel usuario) {
        if (usuario == null) {
            throw new UsuarioObrigatorioError("Usuário não pode ser nulo");
        }

        usuario.aprovarCadastro();
    }

    static public UsuarioModel logar(String usuario, String senha) {
        if (usuario == null || senha == null) {
            return null;
        }

        for (UsuarioModel u : UsuarioCollection.getInstancia().getUsuarios()) {
            if (u.getUsuario() == usuario && u.getSenha() == senha) {
                return u;
            }
        }

        return null;
    }
}
