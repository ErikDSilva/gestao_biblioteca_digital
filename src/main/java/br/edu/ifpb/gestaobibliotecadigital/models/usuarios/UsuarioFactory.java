package br.edu.ifpb.gestaobibliotecadigital.models.usuarios;

public class UsuarioFactory {

    public static Usuario criarUsuario(String tipo, String nome, String id) {
        switch (tipo.toLowerCase()) {
            case "administrador":
                return new Administrador(nome, id);
            case "comum":
                return new LeitorComum(nome, id);
            case "premium":
                return new LeitorPremium(nome, id);
            default:
                throw new IllegalArgumentException("Tipo de usuário inválido: " + tipo);
        }
    }
}