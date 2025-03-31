package br.ifsp.contacts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @NotBlank(message = "A rua não pode estar vazia")
	private String rua;
    
    @NotBlank(message = "A cidade não pode estar vazia")
	private String cidade;
    
    
    /**
     * @NotBlank 	garante que os dados não sejam brancos antes de serem persistidos
     * @Size 		define o tamanho máx e min que deve conter
     * @Pattern		realiza a verificação via regex do formato do campo
     */
    
    @NotBlank(message = "O estado não pode estar vazio")
    @Size(min = 2, max = 2, message = "O estado deve ter exatamente 2 caracteres (sigla)")
    @Pattern(regexp = "[A-Z]{2}", message = "O estado deve ser representado por duas letras maiúsculas")
	private String estado;
    
    @NotBlank(message = "O CEP não pode estar vazio")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 99999-999")
	private String cep;
    
    /**
     * @ManyToOne			Define a relação com a classe Contac, com a coluna contact_id no banco de dados
     * @JoinColumn			
     * @JsonBackReference	é usado para evitar problemas de referência cíclica ao serializar os objetos para JSON.
     */
    
	@ManyToOne 
	@JoinColumn(name = "contact_id", nullable = false)
    @JsonBackReference
	private Contact contact;

	public Address() {
	}

	public Address(String rua, String cidade, String estado, String cep, Contact contact) {
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.contact = contact;
	}
	
	public Long getId() {
		return id;
	}

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

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
