package br.edu.ifpb.gestaobibliotecadigital.filters;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import java.util.List;

public class ReservaFiltro extends Filtro<Reserva> {

    public ReservaFiltro(List<Reserva> reservas) {
        super(reservas);
    }

    public ReservaFiltro porLivro(Livro livro) {
        filtros.add(reserva -> reserva.getLivro()/*.getId()*/ == livro/*.getId()*/);
        return this;
    }

    public ReservaFiltro ativas() {
        filtros.add(reserva -> !reserva.encerrada());
        return this;
    }

    public ReservaFiltro encerradas() {
        filtros.add(reserva -> reserva.encerrada());
        return this;
    }
}
