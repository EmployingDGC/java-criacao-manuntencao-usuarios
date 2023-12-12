package com.pss.model;

import java.time.LocalDateTime;

import com.pss.error.mensagem.MensagemObrigatoriaError;
import com.pss.error.mensagem.TipoMensagemObrigatorioError;
import com.pss.error.mensagem.MensagemJaEnviadaError;
import com.pss.error.usuario.UsuarioObrigatorioError;

import com.pss.model.usuario.UsuarioModel;

public class MensagemModel {
    private UsuarioModel remetente;
    private UsuarioModel destinatario;

    private LocalDateTime dataVisualizacao;
    private LocalDateTime dataEnvio;

    private String mensagem;
    private TipoMensagemModel tipo;

    private boolean lida;
    private boolean enviada;

    public MensagemModel(String mensagem, UsuarioModel remetente, UsuarioModel destinatario, TipoMensagemModel tipo) {
        if (mensagem == null) {
            throw new MensagemObrigatoriaError("O texto da mensagem não pode ser nulo");
        }

        if (remetente == null) {
            throw new UsuarioObrigatorioError("O remetente não pode ser nulo");
        }

        if (destinatario == null) {
            throw new UsuarioObrigatorioError("O destinatário não pode ser nulo");
        }

        if (tipo == null) {
            throw new TipoMensagemObrigatorioError("O tipo da mensagem não pode ser nulo");
        }

        this.destinatario = destinatario;
        this.remetente = remetente;

        this.mensagem = mensagem;

        this.tipo = tipo;
        this.lida = false;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public UsuarioModel getDestinatario() {
        return this.destinatario;
    }

    public UsuarioModel getRemetente() {
        return this.remetente;
    }

    public boolean isLida() {
        return this.lida;
    }

    public void ler() {
        if (this.lida) {
            return;
        }

        this.lida = true;
        this.dataVisualizacao = LocalDateTime.now();
    }

    public boolean isEnviado() {
        return this.enviada;
    }

    public void enviar() {
        if (this.enviada) {
            throw new MensagemJaEnviadaError(String.format("A mensagem já foi enviada ao destinatário `%s`", this.destinatario.getUsuario()));
        }

        this.enviada = true;
        this.dataEnvio = LocalDateTime.now();
    }

    public LocalDateTime getDataVisualizacao() {
        return this.dataVisualizacao;
    }

    public LocalDateTime getDataEnvio() {
        return this.dataEnvio;
    }

    public TipoMensagemModel getTipo() {
        return this.tipo;
    }
}
