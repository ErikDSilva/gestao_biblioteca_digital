package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.utils.Serializador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Repository: Abstração da persistência de dados dos livros.
 */
public class LivroRepository implements IRepository<Livro> {

    private static final String DB_LIVRO = "database/livros.dat";
    public static LivroRepository instance;

    private ArrayList<Livro> livros;

    public LivroRepository() {
        carregar();
    }

    public static LivroRepository getInstance() {
        if (instance == null) {
            instance = new LivroRepository();
        }
        return instance;
    }

    /**
     * Desserializa a lista de livros de um arquivo.
     *
     */
    @Override
    public final void carregar() {
        try {
            ArrayList<Livro> listaDeLivrosCarregados = (ArrayList<Livro>) Serializador.ler(DB_LIVRO);
            this.livros = listaDeLivrosCarregados;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo: " + e.getMessage());
            livros = new ArrayList<>();
            Logger.getLogger(LivroRepository.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro, classe não encontrada: " + e.getMessage());
            livros = new ArrayList<>();
            Logger.getLogger(LivroRepository.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Serializa a lista de livros para um arquivo.
     */
    @Override
    public void salvar() {
        try {
            Serializador.escrever(DB_LIVRO, livros);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado: " + e.getMessage());
            Logger.getLogger(LivroRepository.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Falha ao abrir/fechar o arquivo: " + e.getMessage());
            System.err.println("Ocorreu um erro ao salvar os livros: ");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Livro> listar() {
        return livros;
    }

    @Override
    public void adicionar(Livro livro) {
        livros.add(livro);
        salvar();
    }

    @Override
    public void remover(Livro livro) {
        livros.remove(livro);
        salvar();
    }

    @Override
    public void atualizar(Livro livro) {
        ArrayList<Livro> livrosAtulizar = listar();
        for (int i = 0; i < livrosAtulizar.size(); i++) {
            if (livrosAtulizar.get(i).getIsbn().equals(livro.getIsbn())) {
                livrosAtulizar.set(i, livro);
                break;
            }
        }

        salvar();
    }

    @Override
    public void excluir(Livro livro) {
        ArrayList<Livro> livrosDeletar = listar();
        livrosDeletar.remove(livro);
        salvar();
    }

}
