package br.edu.ifpb.gestaobibliotecadigital.controllers;

import br.edu.ifpb.gestaobibliotecadigital.services.impl.LivroService;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public class LivroController {

    private final LivroService service = new LivroService();

    public Livro cadastrarLivro(Livro livro) {
        Livro livroCadastrado = service.adicionarLivro(livro);
        return livroCadastrado;
    }

    public Livro buscarPorIsbn(String isbn) {
        
    }

}
