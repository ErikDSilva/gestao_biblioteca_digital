package br.edu.ifpb.gestaobibliotecadigital.observers;

import java.util.ArrayList;

public class NotificacaoObserver {

    private final ArrayList<Notificacao> notifications = new ArrayList<>();
    private final ArrayList<NotificacaoListener> listeners = new ArrayList<>();

    public void inscrever(NotificacaoListener listener) {
        listeners.add(listener);
    }

    public void desinscrever(NotificacaoListener listener) {
        listeners.remove(listener);
    }

    public void notificar(Notificacao notificacao) {
        notifications.add(notificacao);

        for (NotificacaoListener listener : listeners) {
            listener.novaMensagem(notificacao);
        }
    }
}
