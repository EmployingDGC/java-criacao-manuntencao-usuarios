package com.pss.error.usuario;

public class SenhaDoUsuarioObrigatorioError extends RuntimeException {
    public SenhaDoUsuarioObrigatorioError(String mensagem) {
        super(mensagem);
    }
}
