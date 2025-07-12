package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.utils.Serializador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Repositorio<T> implements Serializable {

    protected final String dbPath;
    private ArrayList<T> itens;

    protected Repositorio(String dbPath) {
        this.dbPath = dbPath;
        carregar();
    }

    protected abstract String getId(T item);

    public ArrayList<T> listar() {
        return itens;
    }

    public void adicionar(T item) {
        itens.add(item);
        salvar();
    }

    public void atualizar(T item) {
        for (int i = 0; i < itens.size(); i++) {
            if (getId(itens.get(i)).equals(getId(item))) {
                itens.set(i, item);
                break;
            }
        }
        salvar();
    }

    public void excluir(T item) {
        itens.remove(item);
        salvar();
    }

    public void resetar() {
        this.itens.clear();
        excluir();
    }

    private void carregar() {
        try {
            itens = (ArrayList<T>) Serializador.ler(dbPath);
        } catch (FileNotFoundException ex) {
            System.out.println("Aviso: Repositório não existe");
            itens = new ArrayList<>();
        } catch (ClassNotFoundException | IOException ex) {
            System.err.println("Ocorreu um erro ao carregar repositório: ");
            ex.printStackTrace();
            itens = new ArrayList<>();
        }
    }

    private void salvar() {
        try {
            Serializador.escrever(dbPath, itens);
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao salvar repositório: ");
            e.printStackTrace();
        }
    }

    private void excluir() {
        try {
            Serializador.excluir(dbPath);
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao excluir repositório: ");
            e.printStackTrace();
        }
    }
}
