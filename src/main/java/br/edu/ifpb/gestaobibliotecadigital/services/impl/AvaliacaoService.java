/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpb.gestaobibliotecadigital.services.impl;

import br.edu.ifpb.gestaobibliotecadigital.models.avaliacao.Avaliacao;
import br.edu.ifpb.gestaobibliotecadigital.services.interfaces.AvaliacaoObserver;
import java.util.ArrayList;
import java.util.List;


public class AvaliacaoService {
    private List<AvaliacaoObserver> observers = new ArrayList<>();
    
    public void registrarObserver(AvaliacaoObserver observer){
        observers.add(observer);
    }
    
    public void novaAvaliacao(Avaliacao avaliacao){
        for (AvaliacaoObserver obs : observers){
            obs.notificarNovaAvaliacao(avaliacao);
        }
    }
    
}
