package br.com.dbc.pessoa.api.dep.service;

import java.util.Optional;

import br.com.dbc.pessoa.api.dep.dto.LoginDTO;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.dbc.pessoa.api.dep.entity.LoginEntity;
import br.com.dbc.pessoa.api.dep.repository.LoginRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
	
	private final LoginRepository loginRepository;
	private final ObjectMapper mapper;
	
	public Optional<LoginEntity> findByLoginAndPassword(String login, String password) {
		return loginRepository.findByLoginAndPassword(login, password);
	}

	public Optional<LoginEntity> findByLogin(String login) {
		return loginRepository.findByLogin(login);
	}

	public LoginDTO register(LoginDTO loginDTO) throws BusinessRuleException {
		Optional<LoginEntity> exists = this.findByLogin(loginDTO.getLogin());

		if (exists.isPresent()) {
			throw new BusinessRuleException("Login already exists");
		}

		LoginEntity entity = mapper.convertValue(loginDTO, LoginEntity.class);
		entity.setPassword(new BCryptPasswordEncoder().encode(entity.getPassword()));

		this.loginRepository.save(entity);

		return loginDTO;
	}
}
