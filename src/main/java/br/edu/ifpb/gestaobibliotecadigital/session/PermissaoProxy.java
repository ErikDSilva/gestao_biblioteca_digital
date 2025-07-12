package br.edu.ifpb.gestaobibliotecadigital.session;

import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Administrador;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;

public class PermissaoProxy {

    public static boolean podeExcluirLivro() {
        Usuario usuario = UserSessionManager.getInstance().getUsuarioLogado();
        return usuario instanceof Administrador;
    }

    public static boolean podeAvaliarLivro() {
        Usuario usuario = UserSessionManager.getInstance().getUsuarioLogado();
        return usuario != null; // todos os logados podem avaliar
    }

    public static boolean podeAcessarRelatorios() {
        Usuario usuario = UserSessionManager.getInstance().getUsuarioLogado();
        return usuario instanceof Administrador;
    }

    public static boolean podeRealizarEmprestimoPremium() {
        Usuario usuario = UserSessionManager.getInstance().getUsuarioLogado();
        return usuario != null && usuario.getTipo().equals("LeitorPremium");
    }

    // Adicione outras permissões conforme necessário...
}
