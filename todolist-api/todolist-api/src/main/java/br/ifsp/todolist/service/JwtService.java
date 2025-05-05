package br.ifsp.todolist.service;

import java.time.Instant;

import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import br.ifsp.todolist.model.User;

/**
 * Responsavel por gerar tokens JWT válidos a partir das informações de um usuário autenticado
 */

@Service
public class JwtService {
	private final JwtEncoder jwtEncoder;

	public JwtService(JwtEncoder encoder) {
		super();
		this.jwtEncoder = encoder;
	}
	
	public String generateToken(User user) {
		Instant now = Instant.now();
		long expire = 3600L;
		
		  var claims = JwtClaimsSet.builder()
	                .issuer("spring-security")
	                .issuedAt(now)
	                .expiresAt(now.plusSeconds(expire))
	                .subject(user.getUsername())
	                .claim("userId", user.getId())
	                .build();
	    
	        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
		
	}
		
}
