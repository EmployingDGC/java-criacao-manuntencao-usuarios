package com.pss.view;

import javax.swing.JPanel;

public class Painel extends JPanel {
    private Tela tela;

    public Painel(Tela tela) {
        this.tela = tela;
    }

    public Tela getTela() {
        return tela;
    }
}
