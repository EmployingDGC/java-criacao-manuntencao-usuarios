package com.pss.model;

public class PessoaModel {
    private String nome;

    public PessoaModel(String nome) {
        this.nome = nome.trim().toLowerCase();
    }

    public String getNome() {
        return this.nome;
    }
}
