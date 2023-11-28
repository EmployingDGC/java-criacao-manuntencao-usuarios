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

    private JTextField campoPesquisa;

    private JButton botaoPesquisar;
    private JButton botaoNotificar;
    private JButton botaoExcluir;
    private JButton botaoVoltar;
    private JButton botaoEditar;

    public PainelManterUsuarios(TelaPrincipalPresenter telaPresenter) {
        super(telaPresenter);

        JPanel parteSuperior = new JPanel(new BorderLayout());

        this.campoPesquisa = new JTextField(20);
        this.botaoPesquisar = new JButton("Pesquisar");

        JPanel painelPesquisa = new JPanel();
        painelPesquisa.add(this.campoPesquisa);
        painelPesquisa.add(this.botaoPesquisar);

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

        this.botaoEditar = new JButton("Editar");
        this.botaoVoltar = new JButton("Voltar");
        this.botaoExcluir = new JButton("Excluir");
        this.botaoNotificar = new JButton("Notificar");

        parteInferior.add(this.botaoEditar);
        parteInferior.add(this.botaoVoltar);
        parteInferior.add(this.botaoExcluir);
        parteInferior.add(this.botaoNotificar);

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

    public JTextField getCampoPesquisa() {
        return this.campoPesquisa;
    }
    
    public JButton getBotaoPesquisar() {
        return this.botaoPesquisar;
    }

    public JButton getBotaoNotificar() {
        return this.botaoNotificar;
    }

    public JButton getBotaoExcluir() {
        return this.botaoExcluir;
    }

    public JButton getBotaoVoltar() {
        return this.botaoVoltar;
    }

    public JButton getBotaoEditar() {
        return this.botaoEditar;
    }
}
