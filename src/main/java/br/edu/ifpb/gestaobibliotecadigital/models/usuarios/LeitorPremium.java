package br.edu.ifpb.gestaobibliotecadigital.models.usuarios;

public class LeitorPremium extends Usuario{

    public LeitorPremium(String nome, String id){
        super(nome, id);
    }
    
    @Override
    public String getTipo() {
        return "LeitorPremium";
    }

}