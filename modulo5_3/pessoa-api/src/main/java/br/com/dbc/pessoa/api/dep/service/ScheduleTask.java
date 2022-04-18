package br.com.dbc.pessoa.api.dep.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.dbc.pessoa.api.dep.entity.PersonEntity;
import br.com.dbc.pessoa.api.dep.repository.PersonRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ScheduleTask {
	
	private final PersonRepository personRepository;
	private final EmailService emailService;
	
	
	@Scheduled(cron = "0 0 8,20 * * *")
	public void sendEmailIfPersonHaveNoAddress() {
		List<PersonEntity> personsNoAddresses = personRepository.findPersonNoAddresses();
		personsNoAddresses.forEach(person -> {
			StringBuilder message = new StringBuilder();
			message.append("Estamos muito felizes que você está em nosso sistema.\r\n"
					+ "	Para que possamos enviá-los um brinde exclusivo, por gentileza, adicione ou atualize o seu endereço no seu cadastro.\r\n"
					+ "\r\n"
					+ "	Muito obrigado,\r\n"
					+ "	Sistema de Pessoas.");

			emailService.sendEmail(message.toString(), "Adicione um endereco", "Olá " + person.getName(), person.getEmail());
		});
	}
	
	@Scheduled(cron = "@monthly")
	public void sendPromo() {
		List<PersonEntity> persons = personRepository.findAll();
		persons.forEach(person -> {
			StringBuilder message = new StringBuilder();
			message.append(" <br> Selecionamos alguns dos nossos melhores produtos e criamos esta super promoção na nossa plataforma especialmente para você: </br>\r\n"
					+ "                            <br> </br>\r\n"
					+ "                            <br> - Na compra de 1 CDs do Chitãozinho e Xororó, ganhe 1 do Milionário e José Rico.</br>\r\n"
					+ "                            <br> - Na locação de um filme em VHS, a outra locação é grátis</br>\r\n"
					+ "                            <br> - Fita de Super Nintendo com 50% de desconto.</br>\r\n"
					+ "                            <br> </br>\r\n"
					+ "                            <br> Aproveite !</br>\r\n"
					+ "                            <br> Magazine OldSchool.</br>");

			emailService.sendEmail(message.toString(), "GRANDE PROMOÇÂO", "Olá " + person.getName(), person.getEmail());
		});
	}
	
	@Scheduled(cron = "0 0 8 * * *")
	public void sendHappyMessage() {
		List<PersonEntity> persons = personRepository.findAll();
		persons.forEach(person -> {
			StringBuilder message = new StringBuilder();
			message.append("<br> </br>\r\n"
					+ "                            <br> Essa data de " + LocalDate.now() + " também é especial para nós do Vem Ser. Estamos comemorando junto com você. \\o/ </br>\r\n"
					+ "                            <br> </br>\r\n"
					+ "                            <br> Desejamos um feliz aniversário, que sejam " + (LocalDate.now().getYear() - person.getDate().getYear()) +  " anos de muitos. Sucesso, alegria, felicidade e muitas realizações.</br>\r\n"
					+ "                            <br> </br>\r\n"
					+ "                            <br> Forte abraço,</br>\r\n"
					+ "                            <br> #VemSerDBC !</br>");

			emailService.sendEmail(message.toString(), "Meus parabens", "Olá " + person.getName(), person.getEmail());
		});
	}
}
