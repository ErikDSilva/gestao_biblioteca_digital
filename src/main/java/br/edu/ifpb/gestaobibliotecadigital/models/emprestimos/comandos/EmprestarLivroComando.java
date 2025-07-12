package br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.comandos;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.EmprestimoService;

public class EmprestarLivroComando implements ComandoEmprestimo {

    private final EmprestimoService service;
    private final Usuario usuario;
    private final Livro livro;

    public EmprestarLivroComando(EmprestimoService service, Usuario usuario, Livro livro) {
        this.service = service;
        this.usuario = usuario;
        this.livro = livro;
    }

    @Override
    public void executar() {
        service.solicitarEmprestimo(usuario, livro);
    }

}
