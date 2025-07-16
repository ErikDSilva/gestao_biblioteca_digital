package br.edu.ifpb.gestaobibliotecadigital.controllers;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.EmprestimoService;

public class EmprestimoController {

    private final EmprestimoService emprestimoService = new EmprestimoService();

    public void realizarEmprestimo(Usuario usuario, Livro livro) {
        emprestimoService.solicitarEmprestimo(usuario, livro);
    }

    public void renovarEmprestimo(Emprestimo emprestimo) {
        emprestimoService.renovarEmprestimo(emprestimo);
    }

    public void devolverLivro(Emprestimo emprestimo) {
        emprestimoService.devolverLivro(emprestimo);
    }

    public void reservarLivro(Livro livro) {
        emprestimoService.reservarLivro(usuarioLogado, livro);
    }

    public void reservarLivro(Usuario usuario, Livro livro) {
        emprestimoService.reservarLivro(usuario, livro);
    }

    public void cancelarReserva(Reserva reserva) {
        emprestimoService.cancelarReserva(reserva);
    }
}
