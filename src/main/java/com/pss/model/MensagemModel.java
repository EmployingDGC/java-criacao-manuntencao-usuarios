package com.pss.model;

import com.pss.model.usuario.AdministradorModel;
import com.pss.model.usuario.UsuarioModel;

public class MensagemModel {
    private AdministradorModel remetente;
    private UsuarioModel destinatario;

    private String mensagem;

    private boolean lida;

    private MensagemModel(String mensagem, AdministradorModel remetente, UsuarioModel destinatario) {
        this.destinatario = destinatario;
        this.remetente = remetente;

        this.mensagem = mensagem;

        this.lida = false;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public UsuarioModel getDestinatario() {
        return this.destinatario;
    }

    public AdministradorModel getRemetente() {
        return this.remetente;
    }

    public boolean isLida() {
        return this.lida;
    }

    public void ler() {
        this.lida = true;
    }
}
