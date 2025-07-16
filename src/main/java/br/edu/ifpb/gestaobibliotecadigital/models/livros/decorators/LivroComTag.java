package br.edu.ifpb.gestaobibliotecadigital.models.livros.decorators;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import java.util.List;

public class LivroComTag extends LivroDecorator {

    private final List<String> tags;

    public LivroComTag(Livro livro, List<String> tags) {
        super(livro);
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public String getTitulo() {
        return super.getTitulo();
    }

}
