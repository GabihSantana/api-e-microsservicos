package br.ifsp.contacts.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Classe que representa o modelo de dados para um Contato.
 * 
 * @Entity indica que este objeto será mapeado para uma tabela no banco de dados
 *         (em cenários de persistência com JPA).
 */
@Entity
public class Contact {

	/**
	 * @Id indica que este campo é a chave primária (primary key) da entidade.
	 * @GeneratedValue permite que o banco de dados (ou o provedor JPA) gere
	 *                 automaticamente um valor único para cada novo registro.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome não pode estar vazio!")
	private String nome;

	@NotBlank(message = "O telefone não pode estar vazio!")
	@Size(min = 8, max = 15, message = "O telefone deve ter entre 8 e 15 caracteres")
	@Pattern(regexp = "\\d+", message = "O telefone deve conter apenas números")
	private String telefone;

	@NotBlank(message = "O email não pode estar vazio!")
	@Email(message = "O e-mail deve ser válido!")
	private String email;

	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
	// evitar o loop por conta do relacionamento bidirecional ->
	// @JsonManagedReference é colocado onde a serialização ocorre
	@JsonManagedReference
	private List<Address> addresses = new ArrayList<>();

	// Construtor vazio exigido pelo JPA
	public Contact() {
	}

	// Construtor para facilitar a criação de objetos
	public Contact(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	// Getters e Setters
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		if (addresses != null) {
			addresses.forEach(address -> address.setContact(this));

			if (this.addresses == null) {
				this.addresses = new ArrayList<>();
			}

			this.addresses.clear();
			this.addresses.addAll(addresses);
		}
	}

	public Long getId() {
		return id;
	}

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
}
