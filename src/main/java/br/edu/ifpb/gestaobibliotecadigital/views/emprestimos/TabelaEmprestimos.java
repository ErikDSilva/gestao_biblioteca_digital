package br.edu.ifpb.gestaobibliotecadigital.views.emprestimos;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.views.components.TabelaItensPanel;
import java.util.ArrayList;
import java.util.List;

public class TabelaEmprestimos extends TabelaItensPanel<Emprestimo> {

    public TabelaEmprestimos() {
        super(new ArrayList<>());
    }

    public TabelaEmprestimos(List<Emprestimo> emprestimos) {
        super(emprestimos);
    }

    @Override
    protected String[] getColunas() {
        String[] colunas = {"Data", "Usuário", "Livro", "Expira"};
        return colunas;
    }

    @Override
    protected Object getValueAt(Emprestimo item, int coluna) {
        return switch (coluna) {
            case 0 ->
                item.getDataEmprestimo();
            case 1 ->
                item.getUsuario().getNome();
            case 2 ->
                item.getLivro().getTitulo();
            case 3 ->
                item.getDataRenovacaoOuDevolucao();
            default ->
                null;
        };
    }

    @Override
    protected int getColunaOrdenacaoPadrao() {
        return 0;
    }

    @Override
    protected boolean isOrdenacaoDecrescente() {
        return true;
    }
}
