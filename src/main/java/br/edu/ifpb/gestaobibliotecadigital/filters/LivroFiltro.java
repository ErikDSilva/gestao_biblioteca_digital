package br.edu.ifpb.gestaobibliotecadigital.filters;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.utils.Helpers;
import java.util.List;

public class LivroFiltro extends Filtro<Livro> {

    public LivroFiltro(List<Livro> livros) {
        super(livros);
    }

    // Por Livro
    public LivroFiltro porLivro(String isbn) {
        filtros.add((Livro livro) -> {
            return livro.getIsbn().equals(isbn);
        });
        return this;
    }

    // Por autor
    public LivroFiltro porAutor(String nomeAutor) {
        String nomeAutorNormalizado = Helpers.normalizarTexto(nomeAutor);

        filtros.add((Livro livro) -> {
            String autorDoLivroNormalizado = Helpers.normalizarTexto(livro.getAutor());
            return autorDoLivroNormalizado.contains(nomeAutorNormalizado);
        });

        return this;
    }

    // Por Palavras-chave 
    public LivroFiltro porPalavra(String palavraChave) {
        String palavraChaveNormalizado = Helpers.normalizarTexto(palavraChave);

        filtros.add((Livro livro) -> {
            String palavraChaveDoLivroNormalizado = Helpers.normalizarTexto(livro.getTitulo());
            return palavraChaveDoLivroNormalizado.contains(palavraChaveNormalizado);
        });
        return this;
    }

    // Por categoria
    public LivroFiltro porCategoria(String livroCategoria) {
        String categoriaNormalizado = Helpers.normalizarTexto(livroCategoria);
        filtros.add((Livro livro) -> {
            String categoriaDoLivroNormalizado = Helpers.normalizarTexto(livro.getCategoria());
            return categoriaDoLivroNormalizado.contains(categoriaNormalizado);
        });
        return this;
    }

    // Por Ano
    public LivroFiltro porAno(int livroAno) {
        filtros.add(livro -> livro.getAno() == livroAno);
        return this;
    }
}
