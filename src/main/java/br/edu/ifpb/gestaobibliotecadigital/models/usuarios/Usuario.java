package br.edu.ifpb.gestaobibliotecadigital.models.usuarios;

public abstract class Usuario {
    private String nome;
    private String id;

    public Usuario(String nome, String id){
        this.nome = nome;
        this.id = id;
    }

    public abstract String getTipo();

    public String getNome() {
        return nome;

    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return nome + " (" + getTipo() + ")";
    }


}
