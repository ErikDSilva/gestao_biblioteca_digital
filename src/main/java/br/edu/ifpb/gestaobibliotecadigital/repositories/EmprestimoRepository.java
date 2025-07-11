package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.utils.Serializador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmprestimoRepository {

    private static final String DB_PATH = "databases/emprestimos.dat";
    private static EmprestimoRepository instance;
    private ArrayList<Emprestimo> emprestimos;

    private EmprestimoRepository() {
        carregar();
    }

    public static EmprestimoRepository getInstance() {
        if (instance == null) {
            instance = new EmprestimoRepository();
        }
        return instance;
    }

    public ArrayList<Emprestimo> listar() {
        return emprestimos;
    }

    public void adicionar(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
        salvar();
    }

    public void atualizar(Emprestimo emprestimo) {
        for (int i = 0; i < emprestimos.size(); i++) {
            if (emprestimos.get(i).getId().equals(emprestimo.getId())) {
                emprestimos.set(i, emprestimo);
                break;
            }
        }
        salvar();
    }

    public void excluir(Emprestimo emprestimo) {
        emprestimos.remove(emprestimo);
        salvar();
    }

    private void carregar() {
        try {
            Serializador serializador = new Serializador();
            emprestimos = (ArrayList<Emprestimo>) serializador.ler(DB_PATH);
        } catch (FileNotFoundException ex) {
            System.out.println("Aviso: Repositório de empréstimos não existe");
            emprestimos = new ArrayList<>();
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(EmprestimoRepository.class.getName()).log(Level.SEVERE, null, ex);
            emprestimos = new ArrayList<>();
        }
    }

    private void salvar() {
        try {
            Serializador serializador = new Serializador();
            serializador.escrever(DB_PATH, emprestimos);
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao salvar os empréstimos: ");
            e.printStackTrace();
        }
    }
}
