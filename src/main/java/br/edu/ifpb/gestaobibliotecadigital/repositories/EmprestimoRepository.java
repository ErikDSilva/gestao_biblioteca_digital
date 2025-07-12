package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;

public class EmprestimoRepository extends Repositorio<Emprestimo> {

    private static EmprestimoRepository instance;

    private EmprestimoRepository() {
        super("databases/emprestimos.dat");
    }

    @Override
    protected String getId(Emprestimo item) {
        return item.getId().toString();
    }

    public static EmprestimoRepository getInstance() {
        if (instance == null) {
            instance = new EmprestimoRepository();
        }
        return instance;
    }
}
