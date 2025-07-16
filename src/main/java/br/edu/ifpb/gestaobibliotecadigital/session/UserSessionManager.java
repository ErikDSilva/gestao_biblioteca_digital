package br.edu.ifpb.gestaobibliotecadigital.session;

import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.observers.Notificacao;
import br.edu.ifpb.gestaobibliotecadigital.observers.NotificacaoObserver;

public class UserSessionManager {
    private static UserSessionManager instancia;
    private Usuario usuarioLogado;
    private final NotificacaoObserver notificacaoObserver = NotificacaoObserver.getInstance();

    private UserSessionManager() {}

    public static UserSessionManager getInstance() {
        if (instancia == null) {
            instancia = new UserSessionManager();
        }
        return instancia;
    }

    public void login(Usuario usuario) {
        this.usuarioLogado = usuario;
        notificacaoObserver.inscrever(usuario, UserSessionManager::notificacao);
    }

    public void logout() {
        notificacaoObserver.desinscrever(usuarioLogado, UserSessionManager::notificacao);
        this.usuarioLogado = null;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public boolean estaLogado() {
        return usuarioLogado != null;
    }

    private static void notificacao(Notificacao notificacao) {
        System.out.println(notificacao);
    }
}
