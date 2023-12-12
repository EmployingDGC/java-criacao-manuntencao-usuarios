package com.pss.error.usuario;

public class UsuarioObrigatorioError extends RuntimeException {
    public UsuarioObrigatorioError(String mensagem) {
        super(mensagem);
    }
}
