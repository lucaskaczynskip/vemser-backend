package dbc.homework;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Exercicio6 {
	public static void main(String[] args) {
		
		ZonedDateTime dateTimeBrasil = LocalDateTime.now().atZone(ZoneId.of("Brazil/East"));
        ZonedDateTime dateTimeEuropa = LocalDateTime.of(2024, 9, 14, 18, 30).atZone(ZoneId.of("Europe/London"));
        
        long difOffset = dateTimeEuropa.getOffset().getTotalSeconds() - dateTimeBrasil.getOffset().getTotalSeconds();
        
        Period periodo = Period.between(dateTimeBrasil.toLocalDate(), dateTimeEuropa.toLocalDate());
        
        Duration duracao = Duration.between(dateTimeEuropa.minusSeconds(difOffset).toLocalTime(), dateTimeBrasil.toLocalTime());
        
        long hour = duracao.abs().toHours();
        long minutes = duracao.abs().toMinutes() % 60;
        long seconds = duracao.abs().getSeconds() % 60;
        
        System.out.printf("Faltam %d anos, %d meses, %d dias, %d horas, %d minutos, %d segundos para o show!",
        		periodo.getYears(), periodo.getMonths(), periodo.getDays(), hour, minutes, seconds);
	}
	
}
