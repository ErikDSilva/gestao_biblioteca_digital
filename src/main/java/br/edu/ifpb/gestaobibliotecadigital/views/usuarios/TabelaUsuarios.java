package br.edu.ifpb.gestaobibliotecadigital.views.usuarios;

import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.views.components.TabelaItensPanel;
import java.util.ArrayList;
import java.util.List;

public class TabelaUsuarios extends TabelaItensPanel<Usuario> {

    public TabelaUsuarios() {
        super(new ArrayList<>());
    }

    public TabelaUsuarios(List<Usuario> usuarios) {
        super(usuarios);
    }

    @Override
    protected String[] getColunas() {
        String[] colunas = {"Nome"};
        return colunas;
    }

    @Override
    protected Object getValueAt(Usuario item, int coluna) {
        return switch (coluna) {
            case 0 ->
                item.getNome();
            default ->
                null;
        };
    }

    @Override
    protected int getColunaOrdenacaoPadrao() {
        return 0;
    }
}
