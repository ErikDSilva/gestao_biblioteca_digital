package br.edu.ifpb.gestaobibliotecadigital.app;

import br.edu.ifpb.gestaobibliotecadigital.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.emprestimos.estrategias.EmprestimoPadrao;
import br.edu.ifpb.gestaobibliotecadigital.emprestimos.estrategias.EmprestimoPremium;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.utils.DataProvider;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

// ATENÇÃO: Este arquivo Main pertence a Equipe 3 (Jefferson e Marcos),
// e não deve ser alterado por outras equipes
// Este arquivo é temporário, só serve para realizar testes

public class MainEquipe3 {

    public static void main(String[] args) {
        setup();

        Usuario usuario = new Usuario("José", "00000000000000000000000000");
        Livro livro = new Livro("O pequeno príncipe", "", 0, "", "", "", "");

        // Pegou emprestado em 01/07/2025 11:53:00
        // Devolver até: 08/07/2025
        DataProvider.setDateTime("2025-07-01T11:53:00");
        Emprestimo emprestimo = new Emprestimo(usuario, livro, new EmprestimoPadrao());
        System.out.println(emprestimo);

        // Se o cara devolveu em 08/07/2025 10:00:00
        // Sem multa, sem atraso, ficou 7 dias
        emprestimo.setDataDevolvido(LocalDateTime.parse("2025-07-08T12:00:00"));
        System.out.println(emprestimo);

        // Se o cara devolveu em 09/07/2025 10:00:00
        // Atrasou 1 dia, multa 1 real
        emprestimo.setDataDevolvido(LocalDateTime.parse("2025-07-09T10:00:00"));
        System.out.println(emprestimo);

        // Pagou a multa
        emprestimo.setDataPagamentoMulta(LocalDateTime.parse("2025-07-10T11:53:00"));
        System.out.println(emprestimo);

        // Outro empréstimo, dessa vez premium
        // Data: 01/01/2025 17:01
        // Devolver (ou renovar) até: 15/01/2025
        DataProvider.setDateTime("2025-01-01T17:01:00");
        Emprestimo emprestimo2 = new Emprestimo(usuario, livro, new EmprestimoPremium());
        System.out.println(emprestimo2);

        // Renovou dia 14
        DataProvider.setDateTime("2025-01-14T10:15:30");
        emprestimo2.renovar();
        emprestimo2.renovar();
        emprestimo2.renovar();
        emprestimo2.renovar();
        System.out.println(emprestimo2);

        // Renovou dia 29 (não pode, só pode até dia 28)
        // DataProvider.setDateTime("2025-01-29T10:15:30");
        // emprestimo2.renovar();
        // System.out.println(emprestimo2);
        
        // Renovou dia 28 (agora aparece "Devolver" ao invés de "Renovar"
        DataProvider.setDateTime("2025-01-28T10:15:30");
        emprestimo2.renovar();
        System.out.println(emprestimo2);

        // Só pode renovar 5 vezes
        // emprestimo2.renovar();
        
        DataProvider.resetClock();
        System.out.println(emprestimo2);
    }

    private static void setup() {
        // Configura o terminal para mostrar acentos corretamente na saída
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
