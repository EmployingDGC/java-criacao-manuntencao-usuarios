package com.pss.model.usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pss.error.usuario.NomeDeUsuarioObrigatorioError;
import com.pss.error.usuario.SenhaDoUsuarioObrigatorioError;
import com.pss.model.MensagemModel;
import com.pss.model.PessoaModel;
import com.pss.senha.validacao.ValidadorSenha;

public class UsuarioModel extends PessoaModel {
    static final private ValidadorSenha VALIDADOR_SENHA = new ValidadorSenha();

    private String usuario;
    private String senha;

    private boolean cadastroAprovado;

    private LocalDateTime dataCadastro;
    private LocalDateTime dataAprovacaoCadastro;

    private List<MensagemModel> mensagensRecebidas;

    public UsuarioModel(String nome, String usuario, String senha) {
        super(nome);
        this.setUsuario(usuario);
        this.setSenha(senha);

        this.dataCadastro = LocalDateTime.now();
        this.mensagensRecebidas = new ArrayList<MensagemModel>();
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

    private void setUsuario(String usuario) {
        if (usuario == null) {
            throw new NomeDeUsuarioObrigatorioError("Nome de usuário não pode ser nulo");
        }

        usuario = usuario.trim().toLowerCase();

        if (usuario.isEmpty()) {
            throw new NomeDeUsuarioObrigatorioError("Nome de usuário não pode ser vazio");
        }
        
        if (usuario.length() < 4) {
            throw new NomeDeUsuarioObrigatorioError("Nome de usuário deve possuir no mínimo 4 caracteres");
        }

        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        if (UsuarioModel.VALIDADOR_SENHA.validar(senha).size() > 0) {
            throw new SenhaDoUsuarioObrigatorioError("Senha de usuário não passou pelos tratadores do professor");
        }

        // if (senha == null) {
        //     throw new SenhaDoUsuarioObrigatorioError("Senha de usuário não pode ser nula");
        // }

        // senha = senha.trim().toLowerCase();

        // if (senha.isEmpty()) {
        //     throw new SenhaDoUsuarioObrigatorioError("Senha de usuário não pode ser vazia");
        // }
        
        // if (senha.length() < 8) {
        //     throw new SenhaDoUsuarioObrigatorioError("Senha de usuário deve possuir no mínimo 8 caracteres");
        // }

        this.senha = senha;
    }
}
