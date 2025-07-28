package br.edu.ifpb.gestaobibliotecadigital.models.usuarios;

public class LeitorPremium extends Usuario{

    public LeitorPremium(String nome, String id, String username, String senha){
        super(nome, id, username, senha);
    }
    
    @Override
    public String getTipo() {
        return "LeitorPremium";
    }

}