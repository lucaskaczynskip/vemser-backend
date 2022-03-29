package br.com.dbc.pessoa.api.dep.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dbc.pessoa.api.dep.entity.LoginEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {
	
	Optional<LoginEntity> findByLoginAndPassword(String login, String password);
}
