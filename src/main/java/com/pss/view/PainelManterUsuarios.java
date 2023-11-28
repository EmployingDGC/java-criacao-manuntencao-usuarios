package com.pss.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableColumn;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.pss.presenter.TelaPrincipalPresenter;

public class PainelManterUsuarios extends Painel {
    private DefaultTableModel modeloTabela;

    public PainelManterUsuarios(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter);

        JPanel parteSuperior = new JPanel(new BorderLayout());

        JTextField campoPesquisa = new JTextField(20);
        JButton botaoPesquisar = new JButton("Pesquisar");

        JPanel painelPesquisa = new JPanel();
        painelPesquisa.add(campoPesquisa);
        painelPesquisa.add(botaoPesquisar);

        String[] colunas = {"Nome", "Data de Cadastro", "Enviadas", "Lidas"};

        this.modeloTabela = new DefaultTableModel(null, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tabela = new JTable(modeloTabela);
        tabela.getTableHeader().setReorderingAllowed(false);
        
        TableColumnModel colunasModel = tabela.getColumnModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        
        setColumnWidthPercentage(colunasModel.getColumn(0), 60);
        setColumnWidthPercentage(colunasModel.getColumn(1), 20);
        setColumnWidthPercentage(colunasModel.getColumn(2), 10);

        for (int i = 1; i < 4.; i += 1) {
            colunasModel.getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(tabela);

        parteSuperior.add(painelPesquisa, BorderLayout.NORTH);
        parteSuperior.add(scrollPane, BorderLayout.CENTER);

        JPanel parteInferior = new JPanel(new FlowLayout());

        JButton botaoEditar = new JButton("Editar");
        JButton botaoVoltar = new JButton("Voltar");
        JButton botaoExcluir = new JButton("Excluir");
        JButton botaoNotificar = new JButton("Notificar");

        parteInferior.add(botaoEditar);
        parteInferior.add(botaoVoltar);
        parteInferior.add(botaoExcluir);
        parteInferior.add(botaoNotificar);

        this.add(parteSuperior, BorderLayout.CENTER);
        this.add(parteInferior, BorderLayout.SOUTH);
    }

    private void setColumnWidthPercentage(TableColumn column, int percentage) {
        int width = (int) (this.getTelaPresenter().getTela().getWidth() * (percentage / 100.0));
        column.setPreferredWidth(width);
        column.setMaxWidth(width);
        column.setMinWidth(width);
    }

    public void addLinha(String nome, String dataDeCadastro, String mensagensEnviadas, String mensagensLidas) {
        Object[] novaLinha = {nome, dataDeCadastro, mensagensEnviadas, mensagensLidas};

        this.modeloTabela.addRow(novaLinha);
    }

    public void removerTodasAsLinhas() {
        while (this.modeloTabela.getRowCount() > 0) {
            this.modeloTabela.removeRow(0);
        }
    }

    public DefaultTableModel getModeloTabela() {
        return this.modeloTabela;
    }
}
