package br.edu.ifpb.gestaobibliotecadigital.session;

import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;

public class UserSessionManager {
    private static UserSessionManager instancia;
    private Usuario usuarioLogado;

    private UserSessionManager() {}

    public static UserSessionManager getInstance() {
        if (instancia == null) {
            instancia = new UserSessionManager();
        }
        return instancia;
    }

    public void login(Usuario usuario) {
        this.usuarioLogado = usuario;
    }

    public void logout() {
        this.usuarioLogado = null;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public boolean estaLogado() {
        return usuarioLogado != null;
    }
}
