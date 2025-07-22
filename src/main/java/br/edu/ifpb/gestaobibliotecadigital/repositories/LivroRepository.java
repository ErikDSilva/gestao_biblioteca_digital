package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroBase;

/**
 * Repository: Abstração da persistência de dados dos livros.
 */
public class LivroRepository extends Repositorio<LivroBase> {

    private static LivroRepository instance;

    private LivroRepository() {
        super("databases/livro.dat");
    }

    public static LivroRepository getInstance() {
        if (instance == null) {
            instance = new LivroRepository();
        }
        return instance;
    }

    @Override
    protected String getId(LivroBase item) {
        return item.getISBN();
    }

    @Override
    protected String getNome() {
        return "Livros";
    }

}
