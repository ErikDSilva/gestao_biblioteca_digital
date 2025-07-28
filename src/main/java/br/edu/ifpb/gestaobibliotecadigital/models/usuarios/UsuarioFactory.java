package br.edu.ifpb.gestaobibliotecadigital.models.usuarios;

public class UsuarioFactory {

    public static Usuario criarUsuario(String tipo, String nome, String id, String username, String senha) {
        switch (tipo.toLowerCase()) {
            case "administrador":
                return new Administrador(nome, id, username, senha);
            case "comum":
                return new LeitorComum(nome, id, username, senha);
            case "premium":
                return new LeitorPremium(nome, id, username, senha);
            default:
                throw new IllegalArgumentException("Tipo de usuário inválido: " + tipo);
        }
    }
}