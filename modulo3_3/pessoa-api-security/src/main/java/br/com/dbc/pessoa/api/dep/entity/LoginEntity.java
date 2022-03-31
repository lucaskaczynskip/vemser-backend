package br.com.dbc.pessoa.api.dep.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "LOGIN")
public class LoginEntity implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOGIN_PESSOA_SEQ")
    @SequenceGenerator(name = "LOGIN_PESSOA_SEQ", sequenceName = "seq_login", allocationSize = 1)
	@Column(name = "id_login")
	private Integer idLogin;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;

	@ManyToMany
	@JoinTable(
			name = "LOGIN_GROUPS",
			joinColumns = @JoinColumn(name = "id_login"),
			inverseJoinColumns = @JoinColumn(name = "id_group")
	)
	private Set<GroupEntity> groups;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> rules = new ArrayList<>();
		for (GroupEntity groupEntity : groups) {
			rules.addAll(groupEntity.getRoles());
		}
		return rules;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
