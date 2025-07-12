package br.edu.ifpb.gestaobibliotecadigital.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Helpers {

    /**
     * Normaliza o texto
     *
     * @param texto O texto a ser normalizado.
     * @return O texto normalizado
     */
    public static String normalizarTexto(String texto) {
        String normalized = Normalizer.normalize(texto, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("").toLowerCase();
    }
}
