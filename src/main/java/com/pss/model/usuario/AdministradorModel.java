package com.pss.model.usuario;

import java.util.ArrayList;
import java.util.List;

import com.pss.model.MensagemModel;

public class AdministradorModel extends UsuarioModel {
    private List<MensagemModel> mensagensEnviadas;

    public AdministradorModel(String nome, String usuario, String senha) {
        super(nome, usuario, senha);

        this.mensagensEnviadas = new ArrayList<MensagemModel>();
    }

    public List<MensagemModel> getMensagensEnviadas() {
        return this.mensagensEnviadas;
    }

    @Override
    public boolean isAdministrador() {
        return true;
    }
}
