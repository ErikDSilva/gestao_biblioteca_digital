package br.edu.ifpb.gestaobibliotecadigital.filters;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmprestimoFilter {

    private final List<Emprestimo> emprestimos;
    private final ArrayList<Predicate<Emprestimo>> filtros = new ArrayList<>();

    public EmprestimoFilter(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public List<Emprestimo> filtrar() {
        Stream<Emprestimo> emprestimosFiltrados = emprestimos.stream();

        for (Predicate<Emprestimo> filtro : filtros) {
            emprestimosFiltrados = emprestimosFiltrados.filter(filtro);
        }

        return emprestimosFiltrados.collect(Collectors.toList());
    }

    public EmprestimoFilter porLivro(Livro livro) {
        filtros.add(emprestimo -> emprestimo.getLivro()/*.getId()*/ == livro/*.getId()*/);
        return this;
    }

    public EmprestimoFilter devolvido() {
        filtros.add(emprestimo -> emprestimo.foiDevolvido());
        return this;
    }
    
    public EmprestimoFilter naoDevolvido() {
        filtros.add(emprestimo -> !emprestimo.foiDevolvido());
        return this;
    }
}
