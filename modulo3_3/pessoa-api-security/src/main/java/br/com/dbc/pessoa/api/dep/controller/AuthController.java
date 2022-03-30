package br.com.dbc.pessoa.api.dep.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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

	private final AuthenticationManager authenticationManager;
	private final TokenService tokenService;
	private final LoginService loginService;

	@PostMapping
	public String auth(@RequestBody @Valid LoginDTO loginDTO) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
				new UsernamePasswordAuthenticationToken(
						loginDTO.getLogin(),
						loginDTO.getPassword()
				);

		Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		String token = tokenService.getToken(authenticate);
		return token;
	}

	@PostMapping("/register")
	public LoginDTO register(@RequestBody @Valid LoginDTO loginDTO) throws BusinessRuleException {
		return loginService.register(loginDTO);
	}
}
