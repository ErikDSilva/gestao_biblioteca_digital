package br.edu.ifpb.gestaobibliotecadigital.models.livros.decorators;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.ItemBiblioteca;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public abstract class LivroDecorator implements ItemBiblioteca {

    protected Livro livroDecorado;

    public LivroDecorator(Livro livro) {
        this.livroDecorado = livro;
    }

    @Override
    public String getTitulo() {
        return livroDecorado.getTitulo();
    }
}
