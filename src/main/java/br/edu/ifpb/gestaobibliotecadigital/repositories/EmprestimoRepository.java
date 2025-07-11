package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.utils.Serializador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmprestimoRepository {

    private static String DB_PATH = "databases/emprestimos.dat";
    private ArrayList<Emprestimo> emprestimos;

    public ArrayList<Emprestimo> listar() {
        if (emprestimos == null) {
            carregar();
        }
        
        return emprestimos;
    }

    public void adicionar(Emprestimo emprestimo) {
        ArrayList<Emprestimo> emprestimos = listar();
        emprestimos.add(emprestimo);
        salvar();
    }

    public void atualizar(Emprestimo emprestimo) {
        ArrayList<Emprestimo> emprestimos = listar();
        
        for (int i = 0; i < emprestimos.size(); i++) {
            if (emprestimos.get(i).getId().equals(emprestimo.getId())) {
                emprestimos.set(i, emprestimo);
                break;
            }
        }
        
        salvar();
    }

    public void excluir(Emprestimo emprestimo) {
        ArrayList<Emprestimo> emprestimos = listar();
        emprestimos.remove(emprestimo);
        salvar();
    }

    private void carregar() {
        try {
            Serializador serializador = new Serializador();
            ArrayList<Emprestimo> emprestimos = (ArrayList<Emprestimo>) serializador.ler(DB_PATH);
            this.emprestimos = emprestimos;
        } catch (FileNotFoundException ex) {
            System.out.println("Aviso: Repositório de empréstimos não existe");
            this.emprestimos = new ArrayList<>();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmprestimoRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmprestimoRepository.class.getName()).log(Level.SEVERE, null, ex);
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
