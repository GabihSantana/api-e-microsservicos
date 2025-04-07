package br.ifsp.contacts.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

	/**
	 * @OneToMany o contato pode ter vários endereços
	 * mappedBy = "contact" indica que o relacionamento é mapeado pelo atributo contact na classe Address
	 * cascade = CascadeType.ALL: Propaga todas as operações (persistência, remoção, atualização) feitas na 
	 *  							entidade Contact para os seus endereços relacionados.
	 * orphanRemoval = true: Remove automaticamente os endereços que são removidos da lista addresses.
	 * @JsonManagedReference: Trabalha junto com @JsonBackReference na classe Address 
	 * 							para evitar problemas de serialização cíclica (loop infinito) 
	 * 							quando os objetos são convertidos para JSON.
	 */
	
	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	@NotEmpty(message = "O contato deve ter pelo menos um endereço")
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

	// implementado de forma a garantir que todos os endereços associados a este contato estejam sincronizados
	public void setAddresses(List<Address> addresses) {
		if (addresses != null) {
							// garante que o relacionamento bidirecional seja atualizado
			addresses.forEach(address -> address.setContact(this));

			// se for nula, inicializa
			if (this.addresses == null) {
				this.addresses = new ArrayList<>();
			}

			// limpa a lista de endereços atuais -> evita duplicação
			this.addresses.clear();
			// os novos endereços sao adicionados
			this.addresses.addAll(addresses);
		}
	}
}
