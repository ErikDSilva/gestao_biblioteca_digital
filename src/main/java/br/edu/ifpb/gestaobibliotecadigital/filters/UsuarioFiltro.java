package br.edu.ifpb.gestaobibliotecadigital.filters;

import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.utils.Helpers;
import java.util.List;

public class UsuarioFiltro extends Filtro<Usuario> {

    public UsuarioFiltro(List<Usuario> usuarios) {
        super(usuarios);
    }

    public UsuarioFiltro pesquisar(String texto) {
        filtros.add(usuario -> {
            String textoNormal = Helpers.normalizarTexto(texto);
            String nome = Helpers.normalizarTexto(usuario.getNome());
            return nome.contains(textoNormal);
        });
        return this;
    }
}
