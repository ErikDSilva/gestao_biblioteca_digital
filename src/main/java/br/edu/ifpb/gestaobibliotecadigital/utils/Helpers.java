package br.edu.ifpb.gestaobibliotecadigital.utils;

import java.text.Normalizer;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Helpers {

    /**
     * Normaliza o texto.
     *
     * @param texto O texto a ser normalizado.
     * @return O texto normalizado, sem acentuação e em minúsculas.
     */
    public static String normalizarTexto(String texto) {
        String normalized = Normalizer.normalize(texto, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("").toLowerCase();
    }

    /**
     * Array constante com categorias de livro utilizadas para classificação.
     */
    public static final String[] CATEGORIAS = {
        "Selecione...",
        "Romance",
        "Ficção Científica",
        "Fantasia",
        "Suspense",
        "Aventura",
        "História",
        "Filosofia",
        "Poesia",
        "Drama",
        "Infantil",
        "Clássicos de Ficção",
        "Tecnologia",
        "Ciência",};

    /**
     * Gera uma lista de anos, iniciando em 1980 até o ano atual.
     *
     * @return Um array de Strings contendo os anos disponíveis.
     */
    public static String[] getAnos() {
        int anoAtual = Year.now().getValue();
        List<String> anos = new ArrayList<>();
        anos.add("Selecione um ano");
        for (int i = 1980; i <= anoAtual; i++) {
            anos.add(String.valueOf(i));
        }
        return anos.toArray(String[]::new);
    }

}
