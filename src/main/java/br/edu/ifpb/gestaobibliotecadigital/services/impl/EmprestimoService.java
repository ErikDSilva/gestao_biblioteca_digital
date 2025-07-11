package br.edu.ifpb.gestaobibliotecadigital.services.impl;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.repositories.EmprestimoRepository;

public class EmprestimoService {
    private EmprestimoRepository repository = EmprestimoRepository.getInstance();

    void livroDisponivelParaEmprestimo(Livro livro) {
    }

    void livroDisponivelParaReserva(Livro livro) {
    }

    void solicitarEmprestimo(Usuario usuario, Livro livro) {
    }

    void renovarEmprestimo(Usuario usuario, Emprestimo emprestimo) {
    }

    void devolverLivro(Emprestimo emprestimo) {
    }

    void reservarLivro(Emprestimo emprestimo) {
    }

}
