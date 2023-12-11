package com.pss.error.usuario;

public class CredenciaisIncorretasError extends RuntimeException {
    public CredenciaisIncorretasError(String mensagem) {
        super(mensagem);
    }
}
