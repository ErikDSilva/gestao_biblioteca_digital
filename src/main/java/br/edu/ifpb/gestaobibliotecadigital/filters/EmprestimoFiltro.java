package br.edu.ifpb.gestaobibliotecadigital.filters;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import java.util.List;

public class EmprestimoFiltro extends Filtro<Emprestimo> {

    public EmprestimoFiltro(List<Emprestimo> emprestimos) {
        super(emprestimos);
    }

    public EmprestimoFiltro porLivro(Livro livro) {
        filtros.add(emprestimo -> emprestimo.getLivro()/*.getId()*/ == livro/*.getId()*/);
        return this;
    }

    public EmprestimoFiltro devolvido() {
        filtros.add(emprestimo -> emprestimo.foiDevolvido());
        return this;
    }

    public EmprestimoFiltro naoDevolvido() {
        filtros.add(emprestimo -> !emprestimo.foiDevolvido());
        return this;
    }
}
