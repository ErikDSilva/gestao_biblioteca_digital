package br.edu.ifpb.gestaobibliotecadigital.models.livros.decorators;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public class LivroDestacado extends LivroDecorator {

    public LivroDestacado(Livro livro) {
        super(livro);
    }
}
