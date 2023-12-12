package com.pss.error.usuario;

public class NomeDaPessoaObrigatorioError extends RuntimeException {
    public NomeDaPessoaObrigatorioError(String mensagem) {
        super(mensagem);
    }
}
