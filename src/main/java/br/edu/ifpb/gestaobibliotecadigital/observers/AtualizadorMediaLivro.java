/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpb.gestaobibliotecadigital.observers;

import br.edu.ifpb.gestaobibliotecadigital.models.avaliacao.Avaliacao;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.services.interfaces.AvaliacaoObserver;

public class AtualizadorMediaLivro implements AvaliacaoObserver{
    public void notificarNovaAvaliacao(Avaliacao avaliacao){
        Livro livro = avaliacao.getLivro();
        livro.adicionarAvaliacao(avaliacao.getNota());
    }
    
}
