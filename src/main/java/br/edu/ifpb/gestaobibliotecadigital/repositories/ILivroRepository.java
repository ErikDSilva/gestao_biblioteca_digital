package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import java.util.ArrayList;

public interface ILivroRepository {

    /**
     * Desserializa a armazenamento persistente.
     *
     * @return Retorna uma coleção desserializados, ou {@code null} se ocorrer
     * um erro durante a desserialização.
     */
    ArrayList<Livro> deserializarLivros();

    /**
     * Serializa a lista atual com persistência de dados.
     *
     */
    void serializarLivros();
}
