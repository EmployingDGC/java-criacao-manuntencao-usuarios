package com.pss.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

public class Tela extends JFrame {
    private JPanel painelMeio;
    private JLabel titulo;

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

        this.add(painelSuperior, BorderLayout.NORTH);
        this.add(painelInferior, BorderLayout.SOUTH);

        this.setPainelMeio(new JPanel());
        this.setPainelMeio(new PainelFormulario(this)); // temporário
        this.setTitulo("Teste"); // temporário

        this.setVisible(true);
    }

    public JPanel getPainelMeio() {
        return this.painelMeio;
    }

    public void setPainelMeio(JPanel painelMeio) {
        if (this.painelMeio != null) {
            this.remove(this.painelMeio);
        }

        this.painelMeio = painelMeio;
        this.add(painelMeio, BorderLayout.CENTER);

        this.revalidate();
    }

    public void setTitulo(String titulo) {
        this.titulo.setText(titulo);

        this.revalidate();
    }
}
