package br.edu.ifpb.gestaobibliotecadigital.services.auth;

import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.repositories.UsuarioRepository;

import java.util.List;

public class LoginService {
    private static Usuario usuarioLogado = null;

    public static boolean login(String username, String senha) {
        UsuarioRepository repo = UsuarioRepository.getInstance();
        List<Usuario> usuarios = repo.listar();

        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username) && u.getSenha().equals(senha)) {
                usuarioLogado = u;
                return true;
            }
        }
        return false;
    }

    public static void logout() {
        usuarioLogado = null;
    }

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static boolean isAdministrador() {
        return usuarioLogado != null && usuarioLogado.getTipo().equalsIgnoreCase("Administrador");
    }
}
