package com.pss.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class Painel extends JPanel {
    private Tela tela;

    public Painel(Tela tela) {
        this.tela = tela;
        
        this.setLayout(new BorderLayout());
    }

    public Tela getTela() {
        return tela;
    }
}
