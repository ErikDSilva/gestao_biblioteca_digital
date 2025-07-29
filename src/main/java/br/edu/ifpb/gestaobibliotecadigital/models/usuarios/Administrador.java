package br.edu.ifpb.gestaobibliotecadigital.models.usuarios;

public class Administrador extends Usuario{

    public Administrador(String nome, String id, String username, String senha){
        super(nome, id, username, senha);
    }
    
    @Override
    public String getTipo() {
        return "Administrador";
    }

}