package com.pss.error.mensagem;

public class MensagemJaEnviadaError extends RuntimeException {
    public MensagemJaEnviadaError(String mensagem) {
        super(mensagem);
    }
}
