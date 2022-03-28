package dbc.homework;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Qual o dia do seu aniversario: ");
		String dataAniversario = scanner.nextLine();
		
		LocalDate dataN = LocalDate.parse(dataAniversario, DateTimeFormatter.ofPattern("dd/MM/yyyy")).withYear(LocalDate.now().getYear());
		
		LocalDate data = LocalDate.now();
		
		Period periodoAte;
		if (dataN.isBefore(data) || dataN.isEqual(LocalDate.now())) {
			periodoAte = Period.between(data, dataN.plusYears(1));
		} else {
			periodoAte = Period.between(data, dataN);
		}
		
		System.out.println("Falta até seu aniversario -- ");
		System.out.println("Dias: " + periodoAte.getDays());
		System.out.println("Meses: " + periodoAte.getMonths());
		
		System.out.println(periodoAte);
	}
}
