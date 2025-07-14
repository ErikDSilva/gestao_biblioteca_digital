package br.edu.ifpb.gestaobibliotecadigital.observers;

import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;

public class Notificacao {

    private final String mensagem;
    private final Usuario destinatario;

    public Notificacao(String mensagem, Usuario destinatario) {
        this.mensagem = mensagem;
        this.destinatario = destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }
}
