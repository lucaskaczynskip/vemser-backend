package br.com.dbc.pessoa.api.dep.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.dbc.pessoa.api.dep.entity.LoginEntity;
import br.com.dbc.pessoa.api.dep.repository.LoginRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
	
	private final LoginRepository loginRepository;
	
	public Optional<LoginEntity> findByLoginAndPassword(String login, String password) {
		return loginRepository.findByLoginAndPassword(login, password);
	}
}
