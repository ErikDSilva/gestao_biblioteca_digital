package br.edu.ifpb.gestaobibliotecadigital.controllers;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.EmprestimoService;
import br.edu.ifpb.gestaobibliotecadigital.utils.DataProvider;

public class EmprestimoController extends Controller {

    private final EmprestimoService emprestimoService = new EmprestimoService();

    public void realizarEmprestimo(Usuario usuario, Livro livro) {
        verificaUsuarioLogado();
        verificaAdministrador();
        emprestimoService.solicitarEmprestimo(usuario, livro);
    }

    public void renovarEmprestimo(Emprestimo emprestimo) {
        verificaUsuarioLogado();

        // Verifica se é o proprio usuario
        if (!isAdmin() && !usuarioLogado.getId().equals(emprestimo.getUsuario().getId())) {
            throw new IllegalStateException("Você não pode renovar o empréstimo de outra pessoa");
        }

        emprestimoService.renovarEmprestimo(emprestimo);
    }

    public void devolverLivro(Emprestimo emprestimo) {
        verificaUsuarioLogado();
        verificaAdministrador();
        emprestimoService.devolverLivro(emprestimo);
    }

    public void reservarLivro(Livro livro) {
        verificaUsuarioLogado();

        // Caso o usuário seja um administrador, ele deveria utilizar o outro método
        if (isAdmin()) {
            throw new IllegalStateException("Método incorreto para administrador, utilize o método void reservarLivro(Usuario usuario, Livro livro)");
        }

        emprestimoService.reservarLivro(usuarioLogado, livro);
    }

    public void reservarLivro(Usuario usuario, Livro livro) {
        verificaUsuarioLogado();
        verificaAdministrador();
        emprestimoService.reservarLivro(usuario, livro);
    }

    public void cancelarReserva(Reserva reserva) {
        verificaUsuarioLogado();

        // Verifica se é o proprio usuario
        if (!isAdmin() && !usuarioLogado.getId().equals(reserva.getUsuario().getId())) {
            throw new IllegalStateException("Você não pode cancelar a reserva de outra pessoa");
        }

        emprestimoService.cancelarReserva(reserva);
    }

    public void multaPaga(Emprestimo emprestimo) {
        verificaUsuarioLogado();
        verificaAdministrador();
        emprestimoService.multaPaga(emprestimo);
    }

    public void excluir(Emprestimo emprestimo) {
        verificaUsuarioLogado();
        verificaAdministrador();
        emprestimoService.excluir(emprestimo);
    }
}
