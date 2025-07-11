package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.utils.Serializador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Repository: Abstração da persistência de dados dos livros.
 */
public class LivroRepository implements ILivroRepository {

    public ArrayList<Livro> livros = new ArrayList<>();

    private static final String ARQUIVO = "livros.dat";

    /**
     * Desserializa a lista de livros de um arquivo.
     *
     * @return A lista de livros desserializada.
     */
    @Override
    public final ArrayList<Livro> deserializarLivros() {
        try {
            livros = (ArrayList<Livro>) Serializador.ler(ARQUIVO);
            return livros;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro, classe não encontrada: " + e.getMessage());
        }
        return null;
    }

    /**
     * Serializa a lista de livros para um arquivo.
     */
    @Override
    public void serializarLivros() {
        try {
            Serializador.escrever(ARQUIVO, livros);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Falha ao abrir/fechar o arquivo: " + e.getMessage());
        }
    }
}
