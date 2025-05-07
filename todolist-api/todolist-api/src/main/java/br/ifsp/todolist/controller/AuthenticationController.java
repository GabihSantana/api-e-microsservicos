package br.ifsp.todolist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsp.todolist.dto.AuthenticationDTO;
import br.ifsp.todolist.dto.RegisterDTO;
import br.ifsp.todolist.model.User;
import br.ifsp.todolist.repository.UserRepository;
import br.ifsp.todolist.service.AuthenticationService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
	private final AuthenticationService authenticationService;
	private final UserRepository repository;

	public AuthenticationController(AuthenticationService authenticationService, UserRepository repository) {
		this.authenticationService = authenticationService;
		this.repository = repository;
	}

	@PostMapping("/authenticate")
	public ResponseEntity authenticate(@RequestBody @Valid AuthenticationDTO request) {

		// verifica a senha que está codificada no db
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
				request.getUsername(), request.getPassword());
		return ResponseEntity.ok(authenticationService.authenticate(authentication));
	}
	
	@PostMapping("register")
	public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
		if(this.repository.findByUsername(data.getUsername()) != null) return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
		User newUser = new User(data.getUsername(), encryptedPassword, data.getRole());
		
		this.repository.save(newUser);
		
		return ResponseEntity.ok().build();
		
	}
	
}
