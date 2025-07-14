package br.edu.ifpb.gestaobibliotecadigital.observers;

import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NotificacaoObserver {

    private static NotificacaoObserver instance;

    private NotificacaoObserver() {
    }

    public static NotificacaoObserver getInstance() {
        if (instance == null) {
            instance = new NotificacaoObserver();
        }
        return instance;
    }

    private final ArrayList<Notificacao> notifications = new ArrayList<>();
    private final Map<Usuario, ArrayList<NotificacaoListener>> listeners = new HashMap<>();

    public void inscrever(Usuario usuario, NotificacaoListener listener) {
        ArrayList<NotificacaoListener> listenersDoUsuario = getListenersUsuario(usuario);
        listenersDoUsuario.add(listener);
    }

    public void desinscrever(Usuario usuario, NotificacaoListener listener) {
        ArrayList<NotificacaoListener> listenersDoUsuario = getListenersUsuario(usuario);
        listenersDoUsuario.remove(listener);
    }

    public void notificar(Notificacao notificacao) {
        notifications.add(notificacao);

        ArrayList<NotificacaoListener> listenersDoUsuario = getListenersUsuario(notificacao.getDestinatario());

        for (NotificacaoListener listener : listenersDoUsuario) {
            listener.novaMensagem(notificacao);
        }
    }

    private ArrayList<NotificacaoListener> getListenersUsuario(Usuario usuario) {
        if (!listeners.containsKey(usuario)) {
            ArrayList<NotificacaoListener> l = new ArrayList<>();
            listeners.put(usuario, l);
            return l;
        }

        ArrayList<NotificacaoListener> listenersDoUsuario = listeners.get(usuario);
        return listenersDoUsuario;
    }
}
