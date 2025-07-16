package br.edu.ifpb.gestaobibliotecadigital.app;

import br.edu.ifpb.gestaobibliotecadigital.services.impl.EmprestimoService;
import br.edu.ifpb.gestaobibliotecadigital.relatorios.*;


public class MainEquipe5{
    public static void main(String args[]){
    //     EmprestimoService emprestimoService = new EmprestimoService();
    //     var livrosMaisEmprestados = emprestimoService.ranking();
    //     livrosMaisEmprestados.forEach(entry -> {
    //        System.out.println("Livro: " + entry.getKey().getTitulo() + " - Empréstimos: " + entry.getValue());
    //    });

        Relatorio r = new Relatorio();
        r.usuariosMaisAtivos();

    }

}