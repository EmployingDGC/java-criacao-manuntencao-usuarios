package com.pss.model;

import com.pss.model.usuario.AdministradorModel;

public class MensagemModel {
    private AdministradorModel remetente;
    private PessoaModel destinatario;

    private String mensagem;

    private boolean lida;

    private MensagemModel(String mensagem, AdministradorModel remetente, PessoaModel destinatario) {
        this.destinatario = destinatario;
        this.remetente = remetente;

        this.mensagem = mensagem;

        this.lida = false;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public PessoaModel getDestinatario() {
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
