package br.edu.ifpb.gestaobibliotecadigital.utils;

import java.util.ArrayList;
import java.util.List;

public class Paginacao<T> {

    private List<T> itens;
    private int tamanhoDaListagem;
    private int paginaAtual;

    public Paginacao() {
    }

    public Paginacao(List<T> itens, int tamanhoDaListagem) {
        if (tamanhoDaListagem <= 0) {
            throw new IllegalArgumentException("Tamanho da página deve ser maior que 0");
        }
        this.itens = new ArrayList<>(itens);
        this.tamanhoDaListagem = tamanhoDaListagem;
        this.paginaAtual = 0;
    }

    public List<T> getPaginaAtual() {
        int inicio = paginaAtual * tamanhoDaListagem;
        int fim = Math.min(inicio + tamanhoDaListagem, itens.size());
        if (inicio >= itens.size()) {
            return new ArrayList<>();
        }
        return itens.subList(inicio, fim);
    }

    public void proximaPagina() {
        if (temProxima()) {
            paginaAtual++;
        }
    }

    public void paginaAnterior() {
        if (temAnterior()) {
            paginaAtual--;
        }
    }

    public boolean temProxima() {
        return (paginaAtual + 1) * tamanhoDaListagem < itens.size();
    }

    public boolean temAnterior() {
        return paginaAtual > 0;
    }

    public int getNumeroPaginaAtual() {
        return paginaAtual + 1;
    }

    public int getTotalPaginas() {
        return (int) Math.ceil((double) itens.size() / tamanhoDaListagem);
    }
}
