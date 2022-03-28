package dbc.homework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Exercicio5 {
	public static void main(String[] args) {
		
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println("Formato BR: " + now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                .withLocale(new Locale("pt-BR"))));
		System.out.println("Formato Americano: " + now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                .withLocale(new Locale("en"))));
		System.out.println("Formato Francês: " + now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                .withLocale(new Locale("fr"))));
	}
}
