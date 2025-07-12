package br.edu.ifpb.gestaobibliotecadigital.models.livros;

import java.util.ArrayList;
import java.util.List;

public class Colecao implements ItemBiblioteca {
    private final String nome;
    private final List<ItemBiblioteca> colecaoLivro = new ArrayList<>();

    public Colecao(String nome) {
        this.nome = nome;
    }

    public void adicionar(ItemBiblioteca componente) {
        colecaoLivro.add(componente);
    }

    public void remover(ItemBiblioteca componente) {
        colecaoLivro.remove(componente);
    }

    public List<ItemBiblioteca> getComponentes() {
        return colecaoLivro;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String getTitulo() {
        return nome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getTitulo() + "\n");
        for (ItemBiblioteca c : colecaoLivro) {
            sb.append("- ").append(c.getTitulo()).append("\n");
        }
        return sb.toString();
    }
}
