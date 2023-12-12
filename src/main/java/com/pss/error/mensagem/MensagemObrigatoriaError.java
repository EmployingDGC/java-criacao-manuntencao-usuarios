package com.pss.error.mensagem;

public class MensagemObrigatoriaError extends RuntimeException {
    public MensagemObrigatoriaError(String mensagem) {
        super(mensagem);
    }
}
