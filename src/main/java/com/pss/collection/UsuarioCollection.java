package com.pss.collection;

import java.util.ArrayList;
import java.util.List;

import com.pss.model.usuario.UsuarioModel;

public class UsuarioCollection {
    private List<UsuarioModel> usuarios = new ArrayList<UsuarioModel>();

    private static UsuarioCollection instancia;

    private UsuarioCollection() {}

    public static UsuarioCollection getInstancia() {
        return instancia;
    }

    public List<UsuarioModel> getUsuarios() {
        return this.usuarios;
    }

    public void add(UsuarioModel mensagem) {
        this.usuarios.add(mensagem);
    }
}
