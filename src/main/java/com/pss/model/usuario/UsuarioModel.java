package com.pss.model.usuario;

import java.time.LocalDateTime;
import java.util.List;

import com.pss.model.MensagemModel;
import com.pss.model.PessoaModel;

public class UsuarioModel extends PessoaModel {
    private String usuario;
    private String senha;
    private String nome;

    private boolean cadastroAprovado;

    private LocalDateTime dataCadastro;
    private LocalDateTime dataAprovacaoCadastro;

    private List<MensagemModel> mensagensRecebidas;

    public UsuarioModel(String nome, String usuario, String senha) {
        super(nome);
        this.usuario = usuario.trim().toLowerCase();
        this.senha = senha;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getSenha(boolean esconder) {
        if (esconder) {
            return "***";
        }

        return this.senha;
    }

    public String getNome() {
        return this.nome;
    }

    public List<MensagemModel> getMensagensRecebidas() {
        return this.mensagensRecebidas;
    }

    public boolean isCadastroAprovado() {
        return this.cadastroAprovado;
    }

    public void aprovarCadastro() {
        if (this.cadastroAprovado) {
            return;
        }

        this.cadastroAprovado = true;
        this.dataAprovacaoCadastro = LocalDateTime.now();
    }

    public boolean isAdministrador() {
        return false;
    }

    public LocalDateTime getDataAprovacaoCadastro() {
        return this.dataAprovacaoCadastro;
    }

    public LocalDateTime getDataCadastro() {
        return this.dataCadastro;
    }
}
