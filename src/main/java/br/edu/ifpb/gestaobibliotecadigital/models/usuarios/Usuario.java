package br.edu.ifpb.gestaobibliotecadigital.models.usuarios;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    private String id;
    private String nome;
    private String username;
    private String senha;

    public Usuario(String nome, String id, String username, String senha){
        this.nome = nome;
        this.id = id;
        this.username = username;
        this.senha = senha;
    }

    public abstract String getTipo();

    public String getNome() {
        return nome;

    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return nome + " (" + getTipo() + ")";
    }


}
