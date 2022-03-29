package br.com.dbc.pessoa.api.dep.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbc.pessoa.api.dep.dto.LoginDTO;
import br.com.dbc.pessoa.api.dep.entity.LoginEntity;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.security.TokenService;
import br.com.dbc.pessoa.api.dep.service.LoginService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {
	
	private final LoginService loginService;
	private final TokenService tokenService;
	
	@PostMapping
	public String getToken(@RequestBody @Valid LoginDTO login) throws BusinessRuleException {
		Optional<LoginEntity> searched = loginService.findByLoginAndPassword(login.getLogin(), login.getPassword());
		
		if (searched.isPresent()) {
			return tokenService.getToken(searched.get());
		}
		
		throw new BusinessRuleException("Usuário inválido.");
	}
}
