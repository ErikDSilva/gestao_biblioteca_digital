package br.edu.ifpb.gestaobibliotecadigital.observers;

@FunctionalInterface
public interface NotificationListener {

    void onMessage(Notification notificacao);
}
