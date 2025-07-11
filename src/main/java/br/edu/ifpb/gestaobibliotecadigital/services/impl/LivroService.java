package br.edu.ifpb.gestaobibliotecadigital.services.impl;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.repositories.LivroRepository;
import br.edu.ifpb.gestaobibliotecadigital.services.interfaces.ILivroService;
import java.util.List;

public class LivroService implements ILivroService {

    private final LivroRepository livroRepository = new LivroRepository();

    public LivroService() {
        livroRepository.deserializarLivros();
    }

    @Override
    public Livro adicionarLivro(Livro livro) {
        livroRepository.livros.add(livro);
        livroRepository.serializarLivros();
        return livro;
    }

    @Override
    public Livro buscarLivroPorIsbn(String isbn) {
        for (Livro livro : livroRepository.livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    @Override
    public List<Livro> listarTodosLivros() {
        return livroRepository.livros;
    }

    @Override
    public void removerLivro(String isbn) {
        Livro livro = buscarLivroPorIsbn(isbn);
        livroRepository.livros.remove(livro);
        livroRepository.serializarLivros();
    }

}
