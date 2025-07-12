package br.edu.ifpb.gestaobibliotecadigital.services.impl;

import br.edu.ifpb.gestaobibliotecadigital.filters.EmprestimoFiltro;
import br.edu.ifpb.gestaobibliotecadigital.filters.ReservaFiltro;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.repositories.EmprestimoRepository;
import br.edu.ifpb.gestaobibliotecadigital.repositories.ReservaRepository;
import java.util.List;

public class EmprestimoService {

    private EmprestimoRepository emprestimoRepository = EmprestimoRepository.getInstance();
    private ReservaRepository reservaRepository = ReservaRepository.getInstance();

    public boolean livroEstaEmprestado(Livro livro) {
        // Procura se há empréstimos com este livro que não foram devolvidos
        List<Emprestimo> emprestimoNaoDevolvido = new EmprestimoFiltro(emprestimoRepository.listar())
                .porLivro(livro).naoDevolvido().filtrar();

        // Caso haja empréstimos, significa que o livro está com algum usuário
        return emprestimoNaoDevolvido.size() > 0;
    }

    public boolean livroEstaReservado(Livro livro) {
        // Procura se há reservas válidas com este livro
        List<Reserva> reservas = new ReservaFiltro(reservaRepository.listar())
                .porLivro(livro).ativas().filtrar();

        // Caso haja reservas válidas, significa que o livro está reservado
        return reservas.size() > 0;
    }

    public boolean livroDisponivelParaEmprestimo(Livro livro) {
        return !livroEstaEmprestado(livro) && !livroEstaReservado(livro);
    }

    public void livroDisponivelParaReserva(Livro livro) {
    }

    public void solicitarEmprestimo(Usuario usuario, Livro livro) {
    }

    public void renovarEmprestimo(Usuario usuario, Emprestimo emprestimo) {
    }

    public void devolverLivro(Emprestimo emprestimo) {
    }

    public void reservarLivro(Emprestimo emprestimo) {
    }

}
