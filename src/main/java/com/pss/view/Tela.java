package com.pss.view;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Font;

public class Tela extends JFrame {
    private JPanel painelMeio;

    private JLabel usuarioInfoLabel;
    private JLabel titulo;

    private JButton botaoSolicitacoes;
    private JButton botaoNotificaoes;

    public Tela() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());

        this.setTitle("Criação e Manuntenção de Usuários");

        JPanel painelSuperior = new JPanel();
        painelSuperior.setPreferredSize(new Dimension(800, 50));

        this.titulo = new JLabel();
        this.titulo.setFont(new Font("Arial", Font.PLAIN, 30));
        painelSuperior.add(this.titulo, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel();
        painelInferior.setPreferredSize(new Dimension(800, 35));

        this.usuarioInfoLabel = new JLabel();
        this.usuarioInfoLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        painelInferior.add(this.usuarioInfoLabel, BorderLayout.EAST);

        this.botaoSolicitacoes = new JButton();
        this.botaoNotificaoes = new JButton();

        Dimension tamanhoBotao = new Dimension(70, 35);
        this.botaoSolicitacoes.setPreferredSize(tamanhoBotao);
        this.botaoNotificaoes.setPreferredSize(tamanhoBotao);
        
        JPanel botoesEsquerda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        botoesEsquerda.add(botaoSolicitacoes);
        botoesEsquerda.add(botaoNotificaoes);

        painelInferior.add(botoesEsquerda, BorderLayout.WEST);

        this.add(painelSuperior, BorderLayout.NORTH);
        this.add(painelInferior, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public void setPainelMeio(JPanel painelMeio) {
        if (this.painelMeio != null) {
            this.remove(this.painelMeio);
        }

        this.painelMeio = painelMeio;
        this.add(painelMeio, BorderLayout.CENTER);

        this.revalidate();
    }

    public JButton getBotaoSolicitacoes() {
        return this.botaoSolicitacoes;
    }

    public JButton getBotaoNotificaoes() {
        return this.botaoNotificaoes;
    }

    public void setTitulo(String titulo) {
        this.titulo.setText(titulo);

        this.revalidate();
    }

    public void setUsuarioInfo(String info) {
        this.usuarioInfoLabel.setText(info);

        this.revalidate();
    }
}
