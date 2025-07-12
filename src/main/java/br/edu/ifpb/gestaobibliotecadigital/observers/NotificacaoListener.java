package br.edu.ifpb.gestaobibliotecadigital.observers;

@FunctionalInterface
public interface NotificacaoListener {

    void novaMensagem(notificacao notificacao);
}
