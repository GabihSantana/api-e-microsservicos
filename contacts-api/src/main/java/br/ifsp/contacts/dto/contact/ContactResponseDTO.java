package br.ifsp.contacts.dto.contact;

import java.util.List;

import br.ifsp.contacts.dto.address.AddressResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ContactResponseDTO {
	private Long id;
    private String nome;
    private String email;
    private String telefone;
    private List<AddressResponseDTO> addresses;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<AddressResponseDTO> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressResponseDTO> addresses) {
		this.addresses = addresses;
	}

}
