package br.ifsp.contacts.dto.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequestDTO {
	@NotBlank(message = "A rua não pode estar vazia")
	private String rua;

	@NotBlank(message = "A cidade não pode estar vazia")
	private String cidade;

	@NotBlank(message = "O estado não pode estar vazio")
	@Size(min = 2, max = 2, message = "O estado deve ter exatamente 2 caracteres (sigla)")
	@Pattern(regexp = "[A-Z]{2}", message = "O estado deve ser representado por duas letras maiúsculas")
	private String estado;

	@NotBlank(message = "O CEP não pode estar vazio")
	@Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 99999-999")
	private String cep;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
