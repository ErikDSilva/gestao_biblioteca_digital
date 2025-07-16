package br.edu.ifpb.gestaobibliotecadigital.filters;

import br.edu.ifpb.gestaobibliotecadigital.utils.Helpers;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Filtro<T> implements Cloneable {

    protected List<T> itens;
    protected List<Predicate<T>> filtros;

    public Filtro() {
        this.itens = new ArrayList<>();
        this.filtros = new ArrayList<>();
    }

    public Filtro(List<T> itens) {
        this.itens = itens;
        this.filtros = new ArrayList<>();
    }

    public Filtro(List<T> itens, List<Predicate<T>> filtros) {
        this.itens = itens;
        this.filtros = filtros;
    }

    /**
     * Retorna a lista com os filtros usados
     *
     * @return Lista de filtros
     */
    public List<Predicate<T>> getFiltros() {
        return filtros;
    }

    /**
     * Retorna a lista com todos os itens
     *
     * @return Todos os itens
     */
    public List<T> getItens() {
        return itens;
    }

    /**
     * Atualiza a lista com todos os itens
     *
     * @param itens Novos itens a serem filtrados
     * @return Instância de Filtro
     */
    public Filtro<T> setItens(List<T> itens) {
        this.itens = itens;
        return this;
    }

    /**
     * Realiza a filtragem da lista utilizando os filtros
     *
     * @return Lista filtrada
     */
    public List<T> filtrar() {
        Stream<T> itensFiltrados = itens.stream();

        for (Predicate<T> filtro : filtros) {
            itensFiltrados = itensFiltrados.filter(filtro);
        }

        return itensFiltrados.collect(Collectors.toList());
    }

    /**
     * Realiza a filtragem da lista e retorna o primeiro elemento, ou null se
     * não existir
     *
     * @return O primeiro elemento da filtragem ou null
     */
    public T primeiro() {
        List<T> resultado = filtrar();

        if (resultado.isEmpty()) {
            return null;
        }

        return resultado.get(0);
    }

    /**
     * Limpa todos os filtros
     *
     * @return Instância de Filtro
     */
    public Filtro<T> limpar() {
        this.filtros.clear();
        return this;
    }

    @Override
    public Filtro<T> clone() {
        try {
            Filtro<T> copia = (Filtro<T>) super.clone();
            copia.itens = new ArrayList<>(this.itens);
            copia.filtros = new ArrayList<>(this.filtros);
            return copia;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone não suportado", e);
        }
    }
}
