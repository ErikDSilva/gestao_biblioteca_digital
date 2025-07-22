package br.edu.ifpb.gestaobibliotecadigital.views.colecoes;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroBase;
import br.edu.ifpb.gestaobibliotecadigital.views.components.TabelaItensPanel;
import java.util.ArrayList;
import java.util.List;

public class TabelaSelecionadaColecao extends TabelaItensPanel<LivroBase> {

    public TabelaSelecionadaColecao() {
        super(new ArrayList<>());
    }

    public TabelaSelecionadaColecao(List<LivroBase> colecoes) {
        super(colecoes);
    }

    @Override
    protected String[] getColunas() {
        String[] colunas = {"ISBN", "Nome", "Ano"};
        return colunas;
    }

    @Override
    protected Object getValueAt(LivroBase item, int coluna) {
        return switch (coluna) {
            case 0 ->
                item.getISBN();
            case 1 ->
                item.getTitulo();
            case 2 ->
                String.valueOf(item.getAno());
            default ->
                null;
        };
    }

    @Override
    protected int getColunaOrdenacaoPadrao() {
        return 0;
    }
}
