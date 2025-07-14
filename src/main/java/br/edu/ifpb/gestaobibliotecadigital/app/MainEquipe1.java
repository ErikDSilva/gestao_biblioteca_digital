package br.edu.ifpb.gestaobibliotecadigital.app;

import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.UsuarioFactory;
import br.edu.ifpb.gestaobibliotecadigital.session.PermissaoProxy;
import br.edu.ifpb.gestaobibliotecadigital.session.UserSessionManager;

public class MainEquipe1 {
    public static void main(String[] args) {
        Usuario admin = UsuarioFactory.criarUsuario("administrador", "Ronaldo", "001");
        Usuario leitor = UsuarioFactory.criarUsuario("comum", "eduardo", "002");
        Usuario premium = UsuarioFactory.criarUsuario("premium", "erik", "003");

        UserSessionManager session = UserSessionManager.getInstance();
        session.login(admin);

        System.out.println("Usuario logado: " + session.getUsuarioLogado().getNome());

        if (PermissaoProxy.podeExcluirLivro()) {
            System.out.println("Pode excluir livro");
        } else {
            System.out.println("Nao pode excluir livro");
        }

        session.logout();

        session.login(leitor);
        System.out.println("\nUsuario logado: " + session.getUsuarioLogado().getNome());

        if (PermissaoProxy.podeExcluirLivro()) {
            System.out.println("Pode excluir livro.");
        } else {
            System.out.println("Nao pode excluir livro");
        }

        session.logout();

        session.login(premium);
        System.out.println("\nUsuario logado: " + session.getUsuarioLogado().getNome());


        if (PermissaoProxy.podeExcluirLivro()) {
            System.out.println("Pode excluir livro.");
        } else {
            System.out.println("Nao pode excluir livro");
        }
    }
}