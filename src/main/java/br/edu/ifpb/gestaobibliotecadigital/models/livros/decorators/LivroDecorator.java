package br.edu.ifpb.gestaobibliotecadigital.models.livros.decorators;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroBase;
import java.util.UUID;

public abstract class LivroDecorator implements LivroBase {

    protected LivroBase livroDecorado;

    public LivroDecorator(LivroBase livro) {
        this.livroDecorado = livro;
    }

    @Override
    public UUID getId() {
        return livroDecorado.getId();
    }

    @Override
    public String getTitulo() {
        return livroDecorado.getTitulo();
    }

    @Override
    public String getAutor() {
        return livroDecorado.getAutor();
    }

    @Override
    public int getAno() {
        return livroDecorado.getAno();
    }
    
    @Override
    public String getEditora() {
        return livroDecorado.getEditora();
    }

    @Override
    public String getISBN() {
        return livroDecorado.getISBN();
    }

    @Override
    public String getCategoria() {
        return livroDecorado.getCategoria();
    }

    @Override
    public String getSinopse() {
        return livroDecorado.getSinopse();
    }

    @Override
    public String getDescricao() {
        return livroDecorado.getDescricao();
    }

    @Override
    public String toString() {
        return getDescricao();
    }
}