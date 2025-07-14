package br.edu.ifpb.gestaobibliotecadigital.services.interfaces;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import java.util.List;

public interface ILivroService {

    /**
     * Adiciona um novo livro ao sistema.
     *
     * @param livro o livro..
     * @return O livro que foi criado.
     */
    Livro adicionarLivro(Livro livro);

    /**
     * Remove um livro do sistema usando seu ISBN.
     *
     * @param isbn O ISBN do livro a ser removido.
     */
    void removerLivro(String isbn);

    /**
     * Busca um livro específico pelo seu ISBN.
     *
     * @param isbn O ISBN a ser buscado.
     * @return O objeto Livro encontrado ou null se não existir.
     */
    Livro buscarLivroPorIsbn(String isbn);

    /**
     * Retorna uma lista com todos os livros cadastrados no sistema.
     *
     * @return Uma lista de Livros.
     */
    List<Livro> listarTodosLivros();

}
