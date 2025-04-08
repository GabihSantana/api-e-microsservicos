package br.ifsp.contacts.dto.contact;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

import br.ifsp.contacts.dto.address.AddressRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactRequestDTO {
	@NotBlank(message = "O nome não pode estar vazio!")
	private String nome;
	
	@NotBlank(message = "O telefone não pode estar vazio!")
	@Size(min = 8, max = 15, message = "O telefone deve ter entre 8 e 15 caracteres")
	@Pattern(regexp = "\\d+", message = "O telefone deve conter apenas números")
	private String telefone;
	
	@NotBlank(message = "O email não pode estar vazio!")
	@Email(message = "O e-mail deve ser válido!")
	private String email;
	
	@Valid
	@NotEmpty(message = "O contato deve ter pelo menos um endereço")
    private List<AddressRequestDTO> addresses;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AddressRequestDTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressRequestDTO> addresses) {
		this.addresses = addresses;
	}	
	
	
	
}
