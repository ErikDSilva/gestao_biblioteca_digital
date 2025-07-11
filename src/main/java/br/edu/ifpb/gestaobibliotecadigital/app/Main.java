package br.edu.ifpb.gestaobibliotecadigital.app;

import java.io.PrintStream;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        setupOutputCharset();
        setupSwingLook();

        System.out.println("Hello World!");
    }

    /**
     * Configura o terminal para mostrar acentos corretamente na saída
     */
    private static void setupOutputCharset() {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (Exception ex) {
        }
    }

    /**
     * Aplica o tema do sistema nas janelas do Swing
     */
    static void setupSwingLook() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        }
    }
}
