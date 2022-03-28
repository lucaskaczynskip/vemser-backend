package dbc.homework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Exercicio2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite a primeira data: ");
		String data1 = scanner.nextLine();
		System.out.println("Digite a segunda data: ");
		String data2 = scanner.nextLine();
		
		LocalDate data1Data = LocalDate.parse(data1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate data2Data = LocalDate.parse(data2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		if (data1Data.isBefore(data2Data)) {
			System.out.println("Diferença de dias: " + ChronoUnit.DAYS.between(data1Data, data2Data));
			System.out.println("Diferença de meses: " + ChronoUnit.MONTHS.between(data1Data, data2Data));
			System.out.println("Diferença de anos: " + ChronoUnit.YEARS.between(data1Data, data2Data));
		} else {
			System.out.println("Diferença de dias: " + ChronoUnit.DAYS.between(data2Data, data1Data));
			System.out.println("Diferença de meses: " + ChronoUnit.MONTHS.between(data2Data, data1Data));
			System.out.println("Diferença de anos: " + ChronoUnit.YEARS.between(data2Data, data1Data));
		}
	}
}
