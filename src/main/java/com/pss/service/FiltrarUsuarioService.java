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
}
