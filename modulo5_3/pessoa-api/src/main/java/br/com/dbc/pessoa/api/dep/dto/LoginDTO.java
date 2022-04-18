package br.com.dbc.pessoa.api.dep.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class LoginDTO {
	
	@NotEmpty
	private String login;
	
	@NotEmpty
	private String password;
}
