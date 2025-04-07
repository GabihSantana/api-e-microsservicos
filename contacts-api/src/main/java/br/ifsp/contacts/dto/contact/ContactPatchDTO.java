package br.ifsp.contacts.dto.contact;

import java.util.Optional;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactPatchDTO {
	private Optional<@NotBlank(message = "O nome não pode estar vazio!") String> nome = Optional.empty();
	
	private Optional<@NotBlank(message = "O email não pode estar vazio!") 
					@Email(message = "O e-mail deve ser válido!") 
					String> email = Optional.empty();
	
	private Optional<@NotBlank(message = "O telefone não pode estar vazio!") 
					@Size(min = 8, max = 15, message = "O telefone deve ter entre 8 e 15 caracteres") 
					@Pattern(regexp = "\\d+", message = "O telefone deve conter apenas números") 
					String> telefone = Optional.empty();

	public Optional<@NotBlank(message = "O nome não pode estar vazio!") String> getNome() {
		return nome;
	}

	public void setNome(Optional<@NotBlank(message = "O nome não pode estar vazio!") String> nome) {
		this.nome = nome;
	}

	public Optional<@NotBlank(message = "O email não pode estar vazio!") 
					@Email(message = "O e-mail deve ser válido!") 
					String> getEmail() {
		return email;
	}

	public void setEmail(Optional<@NotBlank(message = "O email não pode estar vazio!") 
					@Email(message = "O e-mail deve ser válido!") 
					String> email) {
		this.email = email;
	}

	public Optional<@NotBlank(message = "O telefone não pode estar vazio!") 
					@Size(min = 8, max = 15, message = "O telefone deve ter entre 8 e 15 caracteres") 
					@Pattern(regexp = "\\d+", message = "O telefone deve conter apenas números") 
					String> getTelefone() {
		return telefone;
	}

	public void setTelefone(Optional<@NotBlank(message = "O telefone não pode estar vazio!") 
					@Size(min = 8, max = 15, message = "O telefone deve ter entre 8 e 15 caracteres") 
					@Pattern(regexp = "\\d+", message = "O telefone deve conter apenas números") 
					String> telefone) {
		this.telefone = telefone;
	}
	
}
