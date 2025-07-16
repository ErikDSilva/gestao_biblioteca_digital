package br.edu.ifpb.gestaobibliotecadigital.relatorios;

import java.util.HashMap;
import java.util.Map;

public class dadosFake {
    public Map<String, Integer> categorias = new HashMap<>();
    public Map<String, Integer> usuarios = new HashMap<>();

    void adicionarCategorias(){
        categorias.put("Romance", 5);
        categorias.put("terror", 2);
        categorias.put("comédia",4);
    }
    void adicionarUsuarios(){
        usuarios.put("Joaozinho da Macaxeira", 5);
        usuarios.put("kleber da Mandioca", 2);
        usuarios.put("Fatima da Fenda Funda",4);
    }

    

}
