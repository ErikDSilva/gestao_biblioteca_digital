package br.edu.ifpb.gestaobibliotecadigital.app;

import br.edu.ifpb.gestaobibliotecadigital.services.auth.CadastroService;
import br.edu.ifpb.gestaobibliotecadigital.services.auth.LoginService;
import br.edu.ifpb.gestaobibliotecadigital.views.usuarios.LoginView;
import java.util.Scanner;

public class MainEquipe1 {
    public static void main(String[] args) {
        
        LoginView login = new LoginView();
        login.setVisible(true);
        
        
//        chamarTeste();
    }
    
    private static void chamarTeste() {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("\n===== Sistema da Equipe 1 =====");
            System.out.println("1. Cadastrar");
            System.out.println("2. Login");
            System.out.println("3. Ver usuário logado");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Username: ");
                    String user = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();
                    System.out.print("Tipo (administrador, comum, premium): ");
                    String tipo = scanner.nextLine();
                    boolean sucesso = CadastroService.cadastrar(nome, user, senha, tipo);
                    System.out.println(sucesso ? "Cadastro realizado com sucesso!" : "Usuario já existe!");
                    break;

                case "2":
                    System.out.print("Username: ");
                    String loginUser = scanner.nextLine();
                    System.out.print("Senha: ");
                    String loginPass = scanner.nextLine();
                    boolean logado = LoginService.login(loginUser, loginPass);
                    System.out.println(logado ? "Login bem sucedido!" : "Credenciais inválidas.");
                    break;

                case "3":
                    var usuario = LoginService.getUsuarioLogado();
                    if (usuario != null) {
                        System.out.println("Usuário logado: " + usuario.getNome() + " [" + usuario.getTipo() + "]");
                    } else {
                        System.out.println("Nenhum usuario logado.");
                    }
                    break;

                case "4":
                    executando = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}