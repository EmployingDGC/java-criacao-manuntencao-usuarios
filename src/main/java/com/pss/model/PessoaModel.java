package com.pss.model;

import com.pss.error.usuario.NomeDaPessoaObrigatorioError;

public class PessoaModel {
    private String nome;

    public PessoaModel(String nome) {
        this.setNome(nome);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (nome == null) {
            throw new NomeDaPessoaObrigatorioError("Nome da pessoa não pode ser nula");
        }

        nome = nome.trim().toLowerCase();

        if (nome.isEmpty()) {
            throw new NomeDaPessoaObrigatorioError("Nome da pessoa não pode ser vazia");
        }

        this.nome = nome;
    }
}
