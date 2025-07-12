package br.edu.ifpb.gestaobibliotecadigital.models.livros.decorators;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.ComponenteCatalogo;

public abstract class LivroDecorator implements ComponenteCatalogo {
    protected Livro livroDecorado;

    public LivroDecorator(Livro livro) {
        this.livroDecorado = livro;
    }
    
    public Livro getLivro() {
        return livroDecorado;
    }
}
