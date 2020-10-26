package br.com.pyxis;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TesteDataHora {
    public static void main(String[] args) {
        LocalDate data = LocalDate.now();
        System.out.println(data);
        System.out.println("Dia da semana: " + data.getDayOfWeek().name());
        System.out.println("Dia da semana: " + data.getDayOfWeek().ordinal());
        System.out.println("Mes: " + data.getMonthValue());
        System.out.println("Mes: " + data.getMonth().name());
        System.out.println("Ano: " + data.getYear());
        
        LocalTime tempo = LocalTime.now();
        
        System.out.println(tempo);
        System.out.println("Horas: "+tempo.getHour());
        System.out.println("Minutos: "+tempo.getMinute());
        System.out.println("Segundos: "+tempo.getSecond());
    }
}