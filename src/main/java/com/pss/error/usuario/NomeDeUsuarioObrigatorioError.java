package com.pss.error.usuario;

public class NomeDeUsuarioObrigatorioError extends RuntimeException {
    public NomeDeUsuarioObrigatorioError(String mensagem) {
        super(mensagem);
    }
}
