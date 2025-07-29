package br.edu.ifpb.gestaobibliotecadigital.services.auth;

import java.util.List;

import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.repositories.UsuarioRepository;
import br.edu.ifpb.gestaobibliotecadigital.session.UserSessionManager;

public class LoginService {

    public static boolean login(String username, String senha) {
        UsuarioRepository repo = UsuarioRepository.getInstance();
        List<Usuario> usuarios = repo.listar();

        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username) && u.getSenha().equals(senha)) {
                UserSessionManager.getInstance().login(u); 
                return true;
            }
        }
        return false;
    }

    public static void logout() {
        UserSessionManager.getInstance().logout();
    }

    public static Usuario getUsuarioLogado() {
        return UserSessionManager.getInstance().getUsuarioLogado();
    }

    public static boolean isAdministrador() {
        Usuario u = UserSessionManager.getInstance().getUsuarioLogado();
        return u != null && u.getTipo().equalsIgnoreCase("Administrador");
    }
}

