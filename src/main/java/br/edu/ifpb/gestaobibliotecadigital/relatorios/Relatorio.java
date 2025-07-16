package br.edu.ifpb.gestaobibliotecadigital.relatorios;

import br.edu.ifpb.gestaobibliotecadigital.services.impl.EmprestimoService;


public class Relatorio{

    void livrosMaisEmprestados(){
        EmprestimoService emprestimoService = new EmprestimoService();
        var livrosMaisEmprestados = emprestimoService.ranking();
        livrosMaisEmprestados.forEach(entry -> {
           System.out.println("Livro: " + entry.getKey().getTitulo() + " - Empréstimos: " + entry.getValue());
       });
    }

    public void usuariosMaisAtivos(){
        dadosFake ddf = new dadosFake();

        ddf.adicionarUsuarios();
        System.out.println(ddf.usuarios);
    }
}