package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.utils.Serializador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LivroRepository {

    public static ArrayList<Livro> livros = new ArrayList<>();

    private static final Serializador serializador = new Serializador();
    private static final String ARQUIVO = "livros.dat";

    /**
     * Desserializa a lista de livros de um arquivo.
     *
     * @return A lista de livros desserializada.
     */
    public ArrayList<Livro> deserializarLivros() {
        try {
            livros = (ArrayList<Livro>) serializador.ler(ARQUIVO);

            return livros;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo.");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro, classe não encontrada.");
        }
        return null;
    }

    /**
     * Serializa a lista de livros para um arquivo.
     */
    public void serializarLivros() {
        try {
            serializador.escrever(ARQUIVO, livros);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Falha ao abrir/fechar o arquivo.");
        }
    }

}
