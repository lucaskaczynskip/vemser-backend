package dbc.homework;

import java.time.LocalDateTime;

public class Exercicio4 {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		now = now.plusDays(15);
		now = now.plusHours(10);
		
		System.out.println("Dia da semana: " + now.getDayOfWeek());
		System.out.println("Dia do ano: " + now.getDayOfYear());
	}
}
