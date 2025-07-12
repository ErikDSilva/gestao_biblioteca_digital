package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;
import br.edu.ifpb.gestaobibliotecadigital.utils.Serializador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservaRepository {

    private static final String DB_PATH = "databases/reservas.dat";
    private static ReservaRepository instance;
    private ArrayList<Reserva> reservas;

    private ReservaRepository() {
        carregar();
    }

    public static ReservaRepository getInstance() {
        if (instance == null) {
            instance = new ReservaRepository();
        }
        return instance;
    }

    public ArrayList<Reserva> listar() {
        return reservas;
    }

    public void adicionar(Reserva reserva) {
        reservas.add(reserva);
        salvar();
    }

    public void atualizar(Reserva reserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getId().equals(reserva.getId())) {
                reservas.set(i, reserva);
                break;
            }
        }
        salvar();
    }

    public void excluir(Reserva reserva) {
        reservas.remove(reserva);
        salvar();
    }

    private void carregar() {
        try {
            Serializador serializador = new Serializador();
            reservas = (ArrayList<Reserva>) serializador.ler(DB_PATH);
        } catch (FileNotFoundException ex) {
            System.out.println("Aviso: Repositório de empréstimos não existe");
            reservas = new ArrayList<>();
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(ReservaRepository.class.getName()).log(Level.SEVERE, null, ex);
            reservas = new ArrayList<>();
        }
    }

    private void salvar() {
        try {
            Serializador serializador = new Serializador();
            serializador.escrever(DB_PATH, reservas);
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao salvar os empréstimos: ");
            e.printStackTrace();
        }
    }
}
