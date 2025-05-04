package br.ifsp.todolist.controller;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsp.todolist.service.AuthenticationService;

@RestController
public class AuthenticationController {
	private final AuthenticationService authenticationService;

	public AuthenticationController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}
	
	@PostMapping("authenticate")
	public String authenticate(Authentication authentication) {
		return authenticationService.authenticate(authentication);
	}
	
	
}
