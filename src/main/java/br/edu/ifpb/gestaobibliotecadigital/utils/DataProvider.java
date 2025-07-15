package br.edu.ifpb.gestaobibliotecadigital.utils;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Permite simular horários para testes
 *
 * Para o correto funcionamento, é necessário usar "DataProvider.agora()" dentro
 * dos métodos
 */
public class DataProvider {

    private static Clock clock = Clock.systemDefaultZone();

    /**
     * Altera o clock
     *
     * @param novoClock Novo clock
     */
    public static void setClock(Clock novoClock) {
        clock = novoClock;
    }

    /**
     * Altera a data/hora simulada
     *
     * @param dateTimeString Data/hora no formato ISO sem fuso horário, exemplo:
     * "2025-07-08T12:00:00"
     */
    public static void setDateTime(String dateTimeString) {
        setClock(Clock.fixed(Instant.parse(dateTimeString + "-03:00"), ZoneId.systemDefault()));
    }

    /**
     * Reseta o clock para o horário atual do sistema
     */
    public static void resetClock() {
        clock = Clock.systemDefaultZone();
    }

    /**
     * Retorna a data/hora atual ou simulada
     *
     * @return Data/hora da classe LocalDateTime
     */
    public static LocalDateTime agora() {
        return LocalDateTime.now(clock);
    }

    /**
     * Retorna a data atual ou simulada
     *
     * @return Data da classe LocalDate
     */
    public static LocalDate hoje() {
        return LocalDate.now(clock);
    }
}
