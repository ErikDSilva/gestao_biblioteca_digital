package br.edu.ifpb.gestaobibliotecadigital.filters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Filtro<T> {

    protected final List<T> itens;
    protected final ArrayList<Predicate<T>> filtros = new ArrayList<>();

    public Filtro(List<T> itens) {
        this.itens = itens;
    }

    public List<T> filtrar() {
        Stream<T> itensFiltrados = itens.stream();

        for (Predicate<T> filtro : filtros) {
            itensFiltrados = itensFiltrados.filter(filtro);
        }

        return itensFiltrados.collect(Collectors.toList());
    }
}
