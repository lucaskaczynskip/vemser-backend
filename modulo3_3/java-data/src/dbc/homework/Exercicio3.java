package dbc.homework;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Exercicio3 {
	public static void main(String[] args) {
		System.out.println("Fuso hor�rios");
		
		Instant instant = Instant.now();
		
		System.out.println("Brasil: " + LocalDateTime.now(ZoneId.of("UTC-03:00")));
		System.out.println("Australia: " + LocalDateTime.now(ZoneId.of("UTC+10:00")));
		System.out.println("Jap�o: " + LocalDateTime.now(ZoneId.of("UTC+09:00")));
		System.out.println("R�ssia: " + LocalDateTime.now(ZoneId.of("UTC+03:00")));
		System.out.println("Dubai: " + ZonedDateTime.ofInstant(instant, ZoneId.of( "Asia/Dubai")));
		System.out.println("Estados Unidos: " + LocalDateTime.now(ZoneId.of("UTC-07:00")));
	}
}
