package br.edu.ifpb.gestaobibliotecadigital.models.usuarios;

public class UsuarioFactory {

    public static Usuario criarUsuario(String tipo, String nome, String id) {
        switch (tipo.toLowerCase()) {
            //case "aluno":
                //return new Aluno(nome, id);
            case "leitor comum":
                return new LeitorComum(nome, id);
            default:
                throw new IllegalArgumentException("Tipo de usuário inválido: " + tipo);
        }
    }
    
}