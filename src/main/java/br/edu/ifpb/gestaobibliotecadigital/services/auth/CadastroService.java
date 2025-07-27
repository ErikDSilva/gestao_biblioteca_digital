package br.edu.ifpb.gestaobibliotecadigital.services.auth;

import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.*;
import br.edu.ifpb.gestaobibliotecadigital.repositories.UsuarioRepository;

import java.util.UUID;

public class CadastroService {

    public static boolean cadastrar(String nome, String username, String senha, String tipo) {
        UsuarioRepository repo = UsuarioRepository.getInstance();

        // Verifica se username já existe
        for (Usuario u : repo.listar()) {
            if (u.getUsername().equals(username)) {
                return false; 
            }
        }

        String id = UUID.randomUUID().toString();
        Usuario novoUsuario;

        switch (tipo.toLowerCase()) {
            case "administrador":
                novoUsuario = new Administrador(nome, id, username, senha);
                break;
            case "premium":
                novoUsuario = new LeitorPremium(nome, id, username, senha);
                break;
            default:
                novoUsuario = new LeitorComum(nome, id, username, senha);
        }

        repo.adicionar(novoUsuario);
        return true;
    }
}