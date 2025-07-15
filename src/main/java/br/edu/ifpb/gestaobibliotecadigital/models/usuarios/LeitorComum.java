package br.edu.ifpb.gestaobibliotecadigital.models.usuarios;

public class LeitorComum extends Usuario{

    public LeitorComum(String nome, String id){
        super(nome, id);
    }

    @Override
    public String getTipo() {
        return "LeitorComum";

    }   

}    


    
