package br.com.dbc.pessoa.api.dep.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import br.com.dbc.pessoa.api.dep.dto.LoginDTO;
import br.com.dbc.pessoa.api.dep.entity.GroupEntity;
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
	private final GroupService groupService;
	private final ObjectMapper mapper;
	
	public Optional<LoginEntity> findByLoginAndPassword(String login, String password) {
		return loginRepository.findByLoginAndPassword(login, password);
	}

	public Optional<LoginEntity> findByLogin(String login) {
		return loginRepository.findByLogin(login);
	}

	public LoginDTO register(LoginDTO loginDTO, Integer[] id) throws Exception {
		Optional<LoginEntity> exists = this.findByLogin(loginDTO.getLogin());

		if (exists.isPresent()) {
			throw new BusinessRuleException("Login already exists");
		}

		LoginEntity entity = mapper.convertValue(loginDTO, LoginEntity.class);
		entity.setPassword(new BCryptPasswordEncoder().encode(entity.getPassword()));

		Set<GroupEntity> group = new HashSet<>();
		for (Integer i : id) {
			GroupEntity groupEntity = this.groupService.findById(i);
			group.add(groupEntity);
		}

		entity.setGroups(group);
		this.loginRepository.save(entity);

		return loginDTO;
	}
}
