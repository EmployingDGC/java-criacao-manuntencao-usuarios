package com.pss.model.usuario;

import java.util.List;

import com.pss.model.MensagemModel;
import com.pss.model.PessoaModel;

public class UsuarioModel extends PessoaModel {
    private String usuario;
    private String senha;
    private String nome;

    private List<MensagemModel> mensagensRecebidas;

    public UsuarioModel(String nome, String usuario, String senha) {
        super(nome);
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getSenha(boolean esconder) {
        if (esconder) {
            return "***";
        }

        return this.senha;
    }

    public String getNome() {
        return this.nome;
    }

    public List<MensagemModel> getMensagensRecebidas() {
        return this.mensagensRecebidas;
    }
}
