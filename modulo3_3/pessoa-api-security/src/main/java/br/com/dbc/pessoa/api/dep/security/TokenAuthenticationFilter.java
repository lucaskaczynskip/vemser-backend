package br.com.dbc.pessoa.api.dep.security;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.dbc.pessoa.api.dep.entity.LoginEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

	private final TokenService tokenService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = this.getTokenFromHeader(request);
		
		Optional<LoginEntity> loginOptional = tokenService.isValid(token);
		
		if (loginOptional.isPresent()) {
			LoginEntity login = loginOptional.get();
			
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
					new UsernamePasswordAuthenticationToken(login.getLogin(), login.getPassword(), Collections.emptyList());
			
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		} else {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		
		filterChain.doFilter(request, response);
	}
	
	private String getTokenFromHeader(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		
		if (token == null) {
			return null;
		}
		
		return token;
	}
}
