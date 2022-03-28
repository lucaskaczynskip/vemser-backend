package dbc.homework;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Exercicio6 {
	public static void main(String[] args) {
		
		// data do show
		LocalDateTime dataShow = LocalDateTime.of(2024, 9, 14, 18, 30);
		
		// vou considerar os fusos para definir a hora
		ZoneId zoneId = ZoneId.of("UTC+01:00");
	    ZonedDateTime zonedDateTimeEuropa = ZonedDateTime.of(dataShow, zoneId);
	   
	    LocalDateTime hojeBrasil = LocalDateTime.now();
	    ZoneId zoneIdBr = ZoneId.of("UTC-03:00");
	    ZonedDateTime zonedDateTimeBrasil = ZonedDateTime.of(hojeBrasil, zoneIdBr);
	    
	    System.out.println("Para o show faltam: ");
	    System.out.println("Dias: " + ChronoUnit.DAYS.between(zonedDateTimeBrasil, zonedDateTimeEuropa));
	    System.out.println("Meses: " + ChronoUnit.MONTHS.between(zonedDateTimeBrasil, zonedDateTimeEuropa));
	    System.out.println("Anos: " + ChronoUnit.YEARS.between(zonedDateTimeBrasil, zonedDateTimeEuropa));
	    System.out.println("Horas: " + ChronoUnit.HOURS.between(zonedDateTimeBrasil, zonedDateTimeEuropa));
	    System.out.println("Minutos: " + ChronoUnit.MINUTES.between(zonedDateTimeBrasil, zonedDateTimeEuropa));
	    System.out.println("Segundos: " + ChronoUnit.SECONDS.between(zonedDateTimeBrasil, zonedDateTimeEuropa));
	    
	}
	
}
