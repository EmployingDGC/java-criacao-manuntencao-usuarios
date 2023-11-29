package com.pss.view;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.Insets;

import com.pss.presenter.TelaPrincipalPresenter;

public class PainelMenu extends Painel {
    private JButton botaoManterUsuario;
    private JButton botaoAlterarSenha;
    
    public PainelMenu(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter);

        this.setLayout(new GridBagLayout());

        Dimension tamanhoBotao = new Dimension(150, 50);
        GridBagConstraints gbc = new GridBagConstraints();

        this.botaoManterUsuario = new JButton("Manter Usuário");
        this.botaoManterUsuario.setPreferredSize(tamanhoBotao);

        this.botaoAlterarSenha = new JButton("Alterar Senha");
        this.botaoAlterarSenha.setPreferredSize(tamanhoBotao);

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);
        this.add(this.botaoAlterarSenha, gbc);
        
        gbc.gridy = 1;
        this.add(this.botaoManterUsuario, gbc);
    }

    public JButton getBotaoManterUsuario() {
        return this.botaoManterUsuario;
    }

    public JButton getBotaoAlterarSenha() {
        return this.botaoAlterarSenha;
    }
}
