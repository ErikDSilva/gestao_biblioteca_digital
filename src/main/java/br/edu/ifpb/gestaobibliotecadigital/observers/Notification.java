package br.edu.ifpb.gestaobibliotecadigital.observers;

public class Notification {

    private final String message;

    public Notification(String mensagem) {
        this.message = mensagem;
    }

    public String getMessage() {
        return message;
    }
}
