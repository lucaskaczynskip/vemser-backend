package br.com.dbc.pessoa.api.dep.security;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import br.com.dbc.pessoa.api.dep.entity.LoginEntity;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class TokenService {
	private static final String PREFIX = "Bearer ";
	private static final String HEADER_AUTHORIZATION = "Authorization";
	private static final String KEY_ROLES = "ROLES";

	@Value("${jwt.expiration}")
	private String expiration;

	@Value("${jwt.secret}")
	private String secret;

	public String getToken(Authentication authentication) {
		LoginEntity user = (LoginEntity) authentication.getPrincipal();

		Date now = new Date();
		Date exp = new Date(now.getTime() + Long.parseLong(expiration));

		List<String> roles = user.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());

		String token = Jwts.builder()
				.setIssuer("pessoa-api")
				.setSubject(user.getIdLogin().toString())
				.claim(KEY_ROLES, roles)
				.setIssuedAt(now)
				.setExpiration(exp)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();

		return PREFIX + token;
	}

	public Authentication getAuthentication(HttpServletRequest request) {
		String tokenBearer = request.getHeader(HEADER_AUTHORIZATION); // Bearer hfUIfs

		if (tokenBearer != null) {
			String token = tokenBearer.replace(PREFIX, "");
			Claims body = Jwts.parser()
					.setSigningKey(secret)
					.parseClaimsJws(token)
					.getBody();
				String user = body.getSubject();

			if (user != null) {
				List<String> role = body.get(KEY_ROLES, List.class);
				List<SimpleGrantedAuthority> roles = role.stream()
						.map(SimpleGrantedAuthority::new)
						.collect(Collectors.toList());
				return new UsernamePasswordAuthenticationToken(user, null, roles);
			}
		}
		return null;
	}
}
