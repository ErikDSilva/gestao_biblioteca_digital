package br.edu.ifpb.gestaobibliotecadigital.models.livros;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import br.edu.ifpb.gestaobibliotecadigital.services.interfaces.ComponenteCatalogo ;

public class Colecao implements ComponenteCatalogo ,Serializable {
    private String nome;
    private List<ComponenteCatalogo> componentes = new ArrayList<>();

   public Colecao(String nome) {
        this.nome = nome;
    }

    public void adicionar(LivroComponente componente ){
        componentes.add(componente);
    }

    public void remove(LivroComponente componente){
        componentes.remove(componente);
    }

     public List<ComponenteCatalogo> getComponentes() {
        return componentes;
    }

    public String getNome() {
      return nome;
    }
    
}
