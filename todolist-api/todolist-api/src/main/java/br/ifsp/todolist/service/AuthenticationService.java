package br.ifsp.todolist.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	private final JwtService jwtService;

	public AuthenticationService(JwtService jwtService) {
		super();
		this.jwtService = jwtService;
	}

	public String authenticate(Authentication authentication) {
		return jwtService.generateToken(authentication);
	}
}
