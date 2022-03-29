package br.com.dbc.pessoa.api.dep.security;

import java.util.Base64;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.dbc.pessoa.api.dep.entity.LoginEntity;
import br.com.dbc.pessoa.api.dep.service.LoginService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokenService {
	
	private static final String SEPARATOR = ";";
	private final LoginService loginService;
	
	public String getToken(LoginEntity loginEntity) {
		String tokenText = loginEntity.getLogin() + SEPARATOR + loginEntity.getPassword();
		
		String token = Base64.getEncoder().encodeToString(tokenText.getBytes());
		
		return token;
	}
	
	public Optional<LoginEntity> isValid(String token) {
		if (token == null) {
			return Optional.empty();
		}
		
		byte[] decodedTokenBytes = Base64.getUrlDecoder().decode(token);
		
		String decoded = new String(decodedTokenBytes);
		
		String[] login = decoded.split(SEPARATOR);
		
		return loginService.findByLoginAndPassword(login[0], login[1]);
	}
}
