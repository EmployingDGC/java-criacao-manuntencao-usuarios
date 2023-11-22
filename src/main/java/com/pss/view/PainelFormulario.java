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

    private JCheckBox checkBoxAdministrador;

    private JTextArea campoMensagem;

    private JButton botaoRegistrar;
    private JButton botaoSalvar;
    private JButton botaoVoltar;
    private JButton botaoEntrar;
    private JButton botaoEnviar;

    public PainelFormulario(Tela tela) {
        super(tela);
        
        this.setLayout(new BorderLayout());

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

        this.addCampo(painelSuperior, this.campoNome, "Nome:", gbc);
        this.addCampo(painelSuperior, this.campoUsuario, "Usuário:", gbc);
        this.addCampo(painelSuperior, this.campoSenha, "Senha:", gbc);
        this.addCampo(painelSuperior, this.campoSenhaAtual, "Senha Atual:", gbc);
        this.addCampo(painelSuperior, this.campoNovaSenha, "Nova Senha:", gbc);
        this.addCampo(painelSuperior, new JScrollPane(this.campoMensagem), "Mensagem:", gbc);

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

    private void addCampo(JComponent destino, JComponent extra, String texto, GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy += 1;
        destino.add(new JLabel(texto), gbc);

        gbc.gridx = 1;
        destino.add(extra, gbc);
    }
}
