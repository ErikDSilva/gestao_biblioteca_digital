package br.edu.ifpb.gestaobibliotecadigital.models.usuarios;

public class LeitorComum extends Usuario{

    public LeitorComum(String nome, String id, String username, String senha){
        super(nome, id, username, senha);
    }

    @Override
    public String getTipo() {
        return "LeitorComum";

    }   

}    


    
