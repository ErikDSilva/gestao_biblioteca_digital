package br.edu.ifpb.gestaobibliotecadigital.services.interfaces;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;

public interface IEmprestimoService {

    public Emprestimo solicitarEmprestimo(Usuario usuario, Livro livro);

    public void renovarEmprestimo(Emprestimo emprestimo);

    public void devolverLivro(Emprestimo emprestimo);

    public void reservarLivro(Usuario usuario, Livro livro);

    public void cancelarReserva(Reserva reserva);

    public boolean livroEstaEmprestado(Livro livro);

    public boolean livroEstaReservado(Livro livro);

    public boolean livroDisponivelParaEmprestimo(Livro livro);

    public boolean livroDisponivelParaReserva(Livro livro);
}
