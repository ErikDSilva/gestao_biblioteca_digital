package br.edu.ifpb.gestaobibliotecadigital.models.usuarios;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nome;
    private String id;

    public Usuario(String nome, String id){
        this.nome = nome;
        this.id = id;
    }

    // public String getTipo();

}
