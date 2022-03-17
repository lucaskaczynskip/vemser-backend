package br.com.dbc.pessoa.api.dep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PessoaApiValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PessoaApiValidationApplication.class, args);
	}

}
