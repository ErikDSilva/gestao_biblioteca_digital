package br.edu.ifpb.gestaobibliotecadigital.views.livros;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.views.components.TabelaItensPanel;
import java.util.ArrayList;
import java.util.List;

public class TabelaLivros extends TabelaItensPanel<Livro> {

    public TabelaLivros() {
        super(new ArrayList<>());
    }

    public TabelaLivros(List<Livro> usuarios) {
        super(usuarios);
    }

    @Override
    protected String[] getColunas() {
        String[] colunas = {"Nome"};
        return colunas;
    }

    @Override
    protected Object getValueAt(Livro item, int coluna) {
        return switch (coluna) {
            case 0 ->
                item.getTitulo();
            default ->
                null;
        };
    }

    @Override
    protected int getColunaOrdenacaoPadrao() {
        return 0;
    }
}
