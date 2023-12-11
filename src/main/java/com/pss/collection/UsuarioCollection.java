package com.pss.collection;

import java.util.ArrayList;
import java.util.List;

import com.pss.model.usuario.UsuarioModel;

public class UsuarioCollection {
    private List<UsuarioModel> usuarios;

    private static UsuarioCollection instancia = new UsuarioCollection();

    private UsuarioCollection() {
        this.usuarios = new ArrayList<UsuarioModel>();
    }

    public static UsuarioCollection getInstancia() {
        return instancia;
    }

    public List<UsuarioModel> getUsuarios() {
        return this.usuarios;
    }

    public void add(UsuarioModel usuario) {
        this.usuarios.add(usuario);
    }
}
