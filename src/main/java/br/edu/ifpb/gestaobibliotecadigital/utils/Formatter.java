package br.edu.ifpb.gestaobibliotecadigital.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.function.Function;

/**
 * Classe usada para formatar valores na tabela do Swing
 */
public class Formatter {

    private final Object value;
    private final Function<Object, String> formatter;

    private Formatter(Object value, Function<Object, String> formatter) {
        this.value = value;
        this.formatter = formatter;
    }

    public static Formatter of(Object value) {
        return new Formatter(value, null);
    }

    public static <T> Formatter of(T value, Function<T, String> customFormat) {
        Function<Object, String> f = (Function<Object, String>) customFormat;
        return new Formatter(value, f);
    }

    public String format() {
        return toString();
    }

    @Override
    public String toString() {
        if (formatter != null) {
            return formatter.apply(value);
        }

        if (value == null) {
            return null;
        }

        if (value instanceof LocalDate d) {
            return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(d);
        }

        if (value instanceof LocalDateTime dt) {
            return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(dt);
        }

        if (value instanceof Date date) {
            return new SimpleDateFormat("dd/MM/yyyy").format(date);
        }

        if (value instanceof Number n) {
            return String.format("%.2f", n.doubleValue());
        }

        if (value instanceof Boolean b) {
            return b ? "Sim" : "Não";
        }

        return value.toString();
    }
}
