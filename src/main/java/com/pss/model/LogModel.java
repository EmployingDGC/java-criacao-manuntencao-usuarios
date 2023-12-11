package com.pss.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LogModel {
    static private int contagem = 0;

    private int id;

    private String operacao;
    private String nome;

    private LocalDate data;
    private LocalTime hora;

    private String usuario;

    public LogModel(String operacao, String nome, String usuario) {
        this.nome = nome;
        this.operacao = operacao;
        this.usuario = usuario;

        this.data = LocalDate.now();
        this.hora = LocalTime.now();

        this.id = contagem;
        LogModel.contagem += 1;
    }

    public LocalDate getDataHora() {
        return this.data;
    }

    public String getNome() {
        return this.nome;
    }
    
    public String getOperacao() {
        return this.operacao;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public LocalDate getData() {
        return this.data;
    }

    public LocalTime getHora() {
        return this.hora;
    }

    public int getId() {
        return this.id;
    }

    public String toStringSucesso() {
        return String.format(
            "Sucesso: %s, %s, (%s, %s, %s)",
            this.operacao,
            this.nome,
            this.data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            this.hora.format(DateTimeFormatter.ofPattern("HH:mm:ss")),
            this.usuario
        );
    }

    public String toStringFalha(String mensagem) {
        return String.format(
            "Falha: \"%s\" ao realizar a operação \"%s\" do contato \"%s\", (%s, %s, %s)",
            mensagem,
            this.operacao,
            this.nome,
            this.data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            this.hora.format(DateTimeFormatter.ofPattern("HH:mm:ss")),
            this.usuario
        );
    }
}
