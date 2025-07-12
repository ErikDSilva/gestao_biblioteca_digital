package br.edu.ifpb.gestaobibliotecadigital.app;

import br.edu.ifpb.gestaobibliotecadigital.filters.EmprestimoFiltro;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estrategias.EmprestimoPadrao;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estrategias.EmprestimoPremium;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Administrador;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.repositories.EmprestimoRepository;
import br.edu.ifpb.gestaobibliotecadigital.repositories.ReservaRepository;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.EmprestimoService;
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

//        testarEmprestimos();
//        testarReservas();
//        testarRepositorio();
//        testarFiltros();
        testarService();
    }

    private static void testarEmprestimos() {
        Usuario usuario = new Administrador("José", "00000000000000000000000000");
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

    private static void testarReservas() {
        Usuario usuario = new Administrador("José", "00000000000000000000000000");
        Livro livro = new Livro("O pequeno príncipe", "", 0, "", "", "", "");

        DataProvider.setDateTime("2025-01-01T10:15:30");
        Reserva reserva = new Reserva(usuario, livro);
        System.out.println(reserva);
        DataProvider.setDateTime("2025-01-30T10:15:30");
        System.out.println(reserva);
        DataProvider.setDateTime("2025-01-31T10:15:30");
        System.out.println(reserva);
        reserva.cancelar();
        DataProvider.resetClock();
        System.out.println(reserva);
    }

    private static void testarRepositorio() {
        EmprestimoRepository repo = EmprestimoRepository.getInstance();
        System.out.println(repo.listar());

        Usuario usuario = new Administrador("José", "00000000000000000000000000");
        Livro livro = new Livro("O pequeno príncipe", "", 0, "", "", "", "");
        Emprestimo emprestimo = new Emprestimo(usuario, livro, new EmprestimoPadrao());
        repo.adicionar(emprestimo);

        System.out.println(repo.listar());
    }

    private static void testarFiltros() {
        Usuario usuario = new Administrador("José", "00000000000000000000000000");
        Livro pequeno = new Livro("O pequeno príncipe", "", 0, "", "", "", "");
        Livro diario = new Livro("Diário de um banana", "", 0, "", "", "", "");

        Emprestimo emprestimo1 = new Emprestimo(usuario, pequeno, new EmprestimoPadrao());
        Emprestimo emprestimo2 = new Emprestimo(usuario, diario, new EmprestimoPadrao());

        EmprestimoRepository repo = EmprestimoRepository.getInstance();
        System.out.println(repo.listar());

        repo.adicionar(emprestimo1);
        repo.adicionar(emprestimo2);

        emprestimo2.setDataDevolvido(DataProvider.agora());

        System.out.println(new EmprestimoFiltro(repo.listar())
                .porLivro(diario)
                .devolvido()
                .filtrar()
        );
    }

    private static void testarService() {
        Usuario usuario = new Administrador("José", "00000000000000000000000000");
        Livro pequeno = new Livro("O pequeno príncipe", "", 0, "", "", "", "");
        Livro diario = new Livro("Diário de um banana", "", 0, "", "", "", "");
        EmprestimoRepository erepo = EmprestimoRepository.getInstance();
        ReservaRepository rrepo = ReservaRepository.getInstance();
        erepo.resetar();
        rrepo.resetar();

        System.out.println(new EmprestimoService().livroDisponivelParaEmprestimo(pequeno)); // true

        Emprestimo emprestimo1 = new Emprestimo(usuario, pequeno, new EmprestimoPadrao());
        erepo.adicionar(emprestimo1);

        System.out.println(new EmprestimoService().livroDisponivelParaEmprestimo(pequeno)); // false

        emprestimo1.setDataDevolvido(LocalDateTime.now());

        System.out.println(new EmprestimoService().livroDisponivelParaEmprestimo(pequeno)); // true

        Reserva reserva = new Reserva(usuario, pequeno);
        rrepo.adicionar(reserva);

        System.out.println(new EmprestimoService().livroDisponivelParaEmprestimo(pequeno)); // false

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
