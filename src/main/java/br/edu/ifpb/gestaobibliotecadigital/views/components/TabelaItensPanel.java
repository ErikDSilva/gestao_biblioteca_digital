package br.edu.ifpb.gestaobibliotecadigital.views.components;

import br.edu.ifpb.gestaobibliotecadigital.utils.Formatter;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

public abstract class TabelaItensPanel<T> extends javax.swing.JPanel {

    protected List<T> itens;

    public TabelaItensPanel(List<T> itens) {
        this.itens = itens;

        initComponents();
        initTable();
    }

    /**
     * Define configurações para a tabela
     */
    private void initTable() {
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permite selecionar somente 1 linha
        tabela.setShowGrid(false); // Oculta a grade entre as células
        tabela.setIntercellSpacing(new Dimension(0, 0)); // Remove o espaço entre as células
        tabela.getTableHeader().setReorderingAllowed(false); // Desabilita o reordenamento de colunas
        initTableRowSorter();
        initTableRowFormatter();
        initTableListeners();
    }

    /**
     * Configura a ordenação de linhas da tabela
     */
    private void initTableRowSorter() {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>((TableModel) tabela.getModel());
        tabela.setRowSorter(sorter);

        // Define a coluna de ordenação padrão
        int colunaOrdenacao = getColunaOrdenacaoPadrao();
        if (colunaOrdenacao >= 0) {
            sorter.toggleSortOrder(getColunaOrdenacaoPadrao());
            if (isOrdenacaoDecrescente()) {
                sorter.toggleSortOrder(getColunaOrdenacaoPadrao());
            }
        }
    }

    /**
     * Configura a formatação de dados da tabela (usando a classe Formatter)
     */
    private void initTableRowFormatter() {
        DefaultTableCellRenderer rendererComFormatacao = new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                if (value instanceof Formatter val) {
                    setText(val.toString());
                } else {
                    setText(Formatter.of(value).toString());
                }
            }
        };

        for (int i = 0; i < tabela.getColumnCount(); i++) {
            tabela.getColumnModel().getColumn(i).setCellRenderer(rendererComFormatacao);
        }
    }

    /**
     * Configura os eventos da tabela, como ao selecionar uma linha ou clicar
     * duas vezes
     */
    private void initTableListeners() {
        // Ao clicar duas vezes com o mouse
        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
                    int row = tabela.rowAtPoint(e.getPoint());
                    if (row != -1) {
                        int modelRow = tabela.convertRowIndexToModel(row);
                        T item = itens.get(modelRow);
                        onItemSelecionado(item);
                    }
                }
            }
        });

        // Ao selecionar uma linha
        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int linhaView = tabela.getSelectedRow();
                if (linhaView != -1) {
                    int linhaModel = tabela.convertRowIndexToModel(linhaView);
                    T item = itens.get(linhaModel);
                    onItemDestacado(item);
                }
            }
        });
    }

    /**
     * Atualiza os dados da tabela
     *
     * @param itens Novos dados
     */
    public void setDados(List<T> itens) {
        this.itens = itens;
        ((AbstractTableModel) tabela.getModel()).fireTableDataChanged();
    }

    /**
     * Destaca um item da tabela
     *
     * @param item Item a ser destacado
     */
    public void destacarItem(T item) {
        if (item == null) {
            tabela.clearSelection();
            return;
        }

        int index = itens.indexOf(item);
        if (index <= -1) {
            return;
        }

        tabela.setRowSelectionInterval(index, index);
    }

    /**
     * Retorna o índice a coluna que será ordenada por padrão (-1 é nenhuma)
     *
     * @return Número representando o índice da coluna
     */
    protected int getColunaOrdenacaoPadrao() {
        return -1;
    }

    /**
     * A forma de ordenação dos dados é decrescente
     *
     * @return true se for decrescente, false se for crescente
     */
    protected boolean isOrdenacaoDecrescente() {
        return false;
    }

    /**
     * Retorna o nome das colunas da tabela
     *
     * @return Array de strings
     */
    protected abstract String[] getColunas();

    /**
     * Retorna o valor da célula em uma determinada linha e coluna
     *
     * @param item Item
     * @param coluna Índice da coluna
     * @return Valor (preferência em string)
     */
    protected abstract Object getValueAt(T item, int coluna);

    /**
     * Função que será executada ao destacar um item
     *
     * @param item Item destacado
     */
    protected void onItemDestacado(T item) {
    }

    /**
     * Função que será executada ao selecionar um item
     *
     * @param item Item selecionado
     */
    protected void onItemSelecionado(T item) {
    }

    /**
     * Modelo da tabela do Swing
     */
    class TableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return itens.size();
        }

        @Override
        public int getColumnCount() {
            return getColunas().length;
        }

        @Override
        public String getColumnName(int column) {
            return getColunas()[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return TabelaItensPanel.this.getValueAt(itens.get(rowIndex), columnIndex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabelaScroll = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        tabela.setModel(new TableModel());
        tabelaScroll.setViewportView(tabela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabelaScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabelaScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable tabela;
    private javax.swing.JScrollPane tabelaScroll;
    // End of variables declaration//GEN-END:variables
}
