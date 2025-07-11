package br.edu.ifpb.gestaobibliotecadigital.emprestimos;

import br.edu.ifpb.gestaobibliotecadigital.emprestimos.estrategias.EstrategiaEmprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Emprestimo implements Serializable {

    private final UUID id;
    private final Usuario usuario;
    private final Livro livro;
    private final LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolvido;
    private final ArrayList<LocalDateTime> renovacoes;
    private final EstrategiaEmprestimo estrategiaEmprestimo;
    private LocalDateTime dataPagamentoMulta;

    public Emprestimo(Usuario usuario, Livro livro, EstrategiaEmprestimo estrategiaEmprestimo) {
        this.id = UUID.randomUUID();
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = LocalDateTime.now();
        this.dataDevolvido = null;
        this.renovacoes = new ArrayList<>();
        this.estrategiaEmprestimo = estrategiaEmprestimo;
        this.dataPagamentoMulta = null;
    }

    public UUID getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDateTime getDataDevolvido() {
        return dataDevolvido;
    }

    public ArrayList<LocalDateTime> getRenovacoes() {
        return renovacoes;
    }

    public EstrategiaEmprestimo getEstrategiaEmprestimo() {
        return estrategiaEmprestimo;
    }

    public LocalDateTime getDataPagamentoMulta() {
        return dataPagamentoMulta;
    }

    public void setDataDevolvido(LocalDateTime dataDevolvido) {
        this.dataDevolvido = dataDevolvido;
    }

    public void setDataPagamentoMulta(LocalDateTime dataPagamentoMulta) {
        this.dataPagamentoMulta = dataPagamentoMulta;
    }

}
