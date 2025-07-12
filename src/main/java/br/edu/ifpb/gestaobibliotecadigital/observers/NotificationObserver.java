package br.edu.ifpb.gestaobibliotecadigital.observers;

import java.util.ArrayList;

public class NotificationObserver {
    private final ArrayList<NotificationListener> listeners = new ArrayList<>();
    
    public void subscribe(NotificationListener listener) {
        listeners.add(listener);
    }
    
    public void unsubscribe(NotificationListener listener) {
        listeners.remove(listener);
    }
    
    public void emit(Notification notificacao) {
        for (NotificationListener listener : listeners) {
            listener.onMessage(notificacao);
        }
    }
}
