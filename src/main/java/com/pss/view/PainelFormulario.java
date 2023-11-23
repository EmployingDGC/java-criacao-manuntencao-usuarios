package com.pss.view;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import javax.swing.JComponent;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;

public class PainelFormulario extends Painel {
    private JTextField campoSenhaAtual;
    private JTextField campoNovaSenha;
    private JTextField campoUsuario;
    private JTextField campoSenha;
    private JTextField campoNome;

    private JLabel labelSenhaAtual;
    private JLabel labelNovaSenha;
    private JLabel labelUsuario;
    private JLabel labelSenha;
    private JLabel labelNome;

    private JCheckBox checkBoxAdministrador;

    private JTextArea campoMensagem;

    private JLabel labelMensagem;
    private JScrollPane scrollMensagem;

    private JButton botaoRegistrar;
    private JButton botaoSalvar;
    private JButton botaoVoltar;
    private JButton botaoEntrar;
    private JButton botaoEnviar;

    public PainelFormulario(Tela tela) {
        super(tela);

        JPanel painelSuperior = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        this.campoNome = new JTextField(20);
        this.campoUsuario = new JTextField(20);
        this.campoSenha = new JPasswordField(20);
        this.campoSenhaAtual = new JPasswordField(20);
        this.campoNovaSenha = new JPasswordField(20);
        this.campoMensagem = new JTextArea(5, 20);
        this.checkBoxAdministrador = new JCheckBox("Administrador");

        this.labelNome = new JLabel("Nome:");
        this.labelUsuario = new JLabel("Usuário:");
        this.labelSenha = new JLabel("Senha:");
        this.labelSenhaAtual = new JLabel("Senha Atual:");
        this.labelNovaSenha = new JLabel("Nova Senha:");
        this.labelMensagem = new JLabel("Mensagem:");

        this.scrollMensagem = new JScrollPane(this.campoMensagem);

        this.addCampo(painelSuperior, this.campoNome, labelNome, gbc);
        this.addCampo(painelSuperior, this.campoUsuario, labelUsuario, gbc);
        this.addCampo(painelSuperior, this.campoSenha, labelSenha, gbc);
        this.addCampo(painelSuperior, this.campoSenhaAtual, labelSenhaAtual, gbc);
        this.addCampo(painelSuperior, this.campoNovaSenha, labelNovaSenha, gbc);
        this.addCampo(painelSuperior, this.scrollMensagem, labelMensagem, gbc);

        gbc.gridx = 1;
        gbc.gridy += 1;
        gbc.anchor = GridBagConstraints.CENTER;
        painelSuperior.add(this.checkBoxAdministrador, gbc);

        JPanel painelInferior = new JPanel();
        painelInferior.setPreferredSize(new Dimension(800, 50));

        this.botaoSalvar = new JButton("Salvar");
        this.botaoVoltar = new JButton("Voltar");
        this.botaoEntrar = new JButton("Entrar");
        this.botaoRegistrar = new JButton("Registrar");
        this.botaoEnviar = new JButton("Enviar");

        painelInferior.add(this.botaoSalvar);
        painelInferior.add(this.botaoVoltar);
        painelInferior.add(this.botaoEntrar);
        painelInferior.add(this.botaoRegistrar);
        painelInferior.add(this.botaoEnviar);

        this.add(painelSuperior, BorderLayout.CENTER);
        this.add(painelInferior, BorderLayout.SOUTH);
    }

    private void addCampo(JComponent destino, JComponent extra, JLabel texto, GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy += 1;
        destino.add(texto, gbc);

        gbc.gridx = 1;
        destino.add(extra, gbc);
    }

    public JTextField getCampoNome() {
        return this.campoNome;
    }

    public JTextField getCampoUsuario() {
        return this.campoUsuario;
    }

    public JTextField getCampoSenha() {
        return this.campoSenha;
    }
    
    public JTextField getCampoSenhaAtual() {
        return this.campoSenhaAtual;
    }

    public JTextField getCampoNovaSenha() {
        return this.campoNovaSenha;
    }

    public JTextArea getCampoMensagem() {
        return this.campoMensagem;
    }

    public JButton getBotaoEntrar() {
        return this.botaoEntrar;
    }

    public JButton getBotaoEnviar() {
        return this.botaoEnviar;
    }

    public JButton getBotaoRegistrar() {
        return this.botaoRegistrar;
    }

    public JButton getBotaoSalvar() {
        return this.botaoSalvar;
    }

    public JButton getBotaoVoltar() {
        return this.botaoVoltar;
    }

    public JCheckBox getCheckBoxAdministrador() {
        return this.checkBoxAdministrador;
    }

    public JLabel getLabelMensagem() {
        return this.labelMensagem;
    }

    public JLabel getLabelNome() {
        return this.labelNome;
    }

    public JLabel getLabelNovaSenha() {
        return this.labelNovaSenha;
    }

    public JLabel getLabelSenha() {
        return this.labelSenha;
    }

    public JLabel getLabelSenhaAtual() {
        return this.labelSenhaAtual;
    }

    public JLabel getLabelUsuario() {
        return this.labelUsuario;
    }

    public JScrollPane getScrollMensagem() {
        return this.scrollMensagem;
    }
}
