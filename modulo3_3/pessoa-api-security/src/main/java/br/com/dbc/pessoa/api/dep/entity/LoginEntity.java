package br.com.dbc.pessoa.api.dep.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "LOGIN")
public class LoginEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOGIN_PESSOA_SEQ")
    @SequenceGenerator(name = "LOGIN_PESSOA_SEQ", sequenceName = "seq_login", allocationSize = 1)
	@Column(name = "id_login")
	private Integer idLogin;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
}
