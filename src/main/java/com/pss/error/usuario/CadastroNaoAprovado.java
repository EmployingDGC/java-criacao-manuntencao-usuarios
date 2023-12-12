package com.pss.error.usuario;

public class CadastroNaoAprovado extends RuntimeException {
    public CadastroNaoAprovado(String mensagem) {
        super(mensagem);
    }
}
