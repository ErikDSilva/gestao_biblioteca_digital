package br.edu.ifpb.gestaobibliotecadigital.services.interfaces;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import java.util.List;

public interface ILivroService {

    /**
     * Adiciona um novo livro ao sistema.
     *
     * @param titulo O título do livro.
     * @param autor O autor do livro.
     * @param ano O ano de publicação.
     * @param editora A editora do livro.
     * @param isbn O ISBN (identificador único).
     * @param sinopse A sinopse do livro.
     * @param categoria A categoria do livro.
     * @return O livro que foi criado.
     */
    Livro adicionarLivro(String titulo, String autor, int ano, String editora, String isbn, String sinopse, String categoria);

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
