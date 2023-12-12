package com.pss.error.mensagem;

public class TipoMensagemObrigatorioError extends RuntimeException {
    public TipoMensagemObrigatorioError(String mensagem) {
        super(mensagem);
    }
}
