package br.ifsp.todolist.configuration;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;

import br.ifsp.todolist.security.CustomJwtAuthenticationConverter;

/**
 * Responsável por configurar as regras de segurança da aplicação
 * 
 * @Configuration: Indica que esta classe contém definições de beans para o contexto do Spring.
 * @EnableWebSecurity: Ativa o suporte à segurança via Spring Security para aplicações web (Servlet).
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Value("${jwt.public.key}")
	private RSAPublicKey key;
	
	@Value("${jwt.private.key}")
	private RSAPrivateKey priv;
	
    @Bean
    public CustomJwtAuthenticationConverter customJwtAuthenticationConverter() {
        return new CustomJwtAuthenticationConverter();
    }
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, 
				CustomJwtAuthenticationConverter customJwtAuthenticationConverter) throws Exception {
		http.csrf(csrf -> csrf.disable()) // desativa proteção contra CSRF - aplicação é stateless (sem sessão)
			.authorizeHttpRequests(auth -> auth.requestMatchers("/api/auth/**").permitAll() // login emissão de tokens
					.requestMatchers("/api/users/register").permitAll().anyRequest().authenticated()) // registro de novos users
			.oauth2ResourceServer(
                    conf -> conf.jwt(jwt -> jwt.jwtAuthenticationConverter(customJwtAuthenticationConverter)))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // garante que nenhuma sessão HTTP será criada/usada

		return http.build();
	}
	
	@Bean
	JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withPublicKey(this.key).build();
	}
	
	@Bean
	JwtEncoder jwtEncoder() {
		var jwk = new RSAKey.Builder(this.key).privateKey(this.priv).build();
		var jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
		
		return new NimbusJwtEncoder(jwks);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
