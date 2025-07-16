package br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estados;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import java.io.Serializable;

public abstract class EstadoLivro implements Serializable {

    protected Livro livro;

    public EstadoLivro(Livro livro) {
        this.livro = livro;
    }

    public abstract String getNome();

    public abstract void devolver();

    public abstract void emprestar();

    public abstract void reservar();

    public abstract void atrasar();

    public abstract void expirarReserva();

}
