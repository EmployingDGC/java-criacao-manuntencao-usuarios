package com.pss.service;

import java.util.ArrayList;
import java.util.List;

import com.pss.collection.UsuarioCollection;
import com.pss.model.usuario.AdministradorModel;
import com.pss.model.usuario.UsuarioModel;

public class FiltrarUsuarioService {
    static private List tipo(Class c) {
        List usuarios = new ArrayList<>();

        for (UsuarioModel u : UsuarioCollection.getInstancia().getUsuarios()) {
            if (u.getClass() == c) {
                usuarios.add(u);
            }
        }

        return usuarios;
    }

    static public List<UsuarioModel> usuarioComum() {
        return tipo(UsuarioModel.class);
    }

    static public List<AdministradorModel> usuarioAdministrador() {
        return tipo(AdministradorModel.class);
    }

    static public UsuarioModel usuarioESenha(String usuario, String senha) {
        for (UsuarioModel u : UsuarioCollection.getInstancia().getUsuarios()) {
            if (u.getUsuario().equals(usuario) && u.getSenha().equals(senha)) {
                return u;
            }
        }

        return null;
    }

    static public List<UsuarioModel> usuario(String usuario) {
        List<UsuarioModel> usuarios = new ArrayList<>();

        for (UsuarioModel u : UsuarioCollection.getInstancia().getUsuarios()) {
            if (u.getUsuario().equals(usuario)) {
                usuarios.add(u);
            }
        }

        return usuarios;
    }
}
