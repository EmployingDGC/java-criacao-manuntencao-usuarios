package com.pss.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.pss.presenter.TelaPrincipalPresenter;

public class Painel extends JPanel {
    private TelaPrincipalPresenter telaPresenter;

    public Painel(TelaPrincipalPresenter telaPresenter) {
        this.telaPresenter = telaPresenter;
        
        this.setLayout(new BorderLayout());
    }

    public TelaPrincipalPresenter getTelaPresenter() {
        return this.telaPresenter;
    }
}
