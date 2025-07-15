package br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.comandos;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.EmprestimoService;

public class RenovarLivroComando implements ComandoEmprestimo {

    private final EmprestimoService service;
    private final Emprestimo emprestimo;

    public RenovarLivroComando(EmprestimoService service, Emprestimo emprestimo) {
        this.service = service;
        this.emprestimo = emprestimo;
    }

    @Override
    public void executar() {
        service.renovarEmprestimo(emprestimo);
    }

}
