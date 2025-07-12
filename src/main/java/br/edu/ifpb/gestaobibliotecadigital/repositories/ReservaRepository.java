package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;

public class ReservaRepository extends Repositorio<Reserva> {

    private static ReservaRepository instance;

    private ReservaRepository() {
        super("databases/reservas.dat");
    }

    @Override
    protected String getId(Reserva item) {
        return item.getId().toString();
    }

    public static ReservaRepository getInstance() {
        if (instance == null) {
            instance = new ReservaRepository();
        }
        return instance;
    }
}
