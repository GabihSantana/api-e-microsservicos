package br.ifsp.contacts.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ifsp.contacts.model.Contact;
import br.ifsp.contacts.repository.ContactRepository;
import exception.ResourceNotFoundException;

/**
 * Classe responsável por mapear as rotas/endpoints relacionados aos contatos.
 * Cada método abaixo corresponde a uma operação em nosso sistema.
 * 
 * @RestController: Indica que esta classe é um controlador responsável por
 *                  responder requisições
 *                  REST. @RequestMapping("/api/contacts"): Indica o caminho
 *                  base.
 */
@RestController
@RequestMapping("/api/contacts")
public class ContactController {

	/**
	 * @Autowired permite que o Spring "injete" automaticamente uma instância de
	 *            ContactRepository aqui, sem que precisemos criar manualmente.
	 */
	@Autowired
	private ContactRepository contactRepository;

	/**
	 * Método para obter todos os contatos.
	 * 
	 * @GetMapping indica que este método vai responder a chamadas HTTP GET. Exemplo
	 *             de acesso: GET /api/contacts
	 */
	@GetMapping
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	/**
	 * Método para obter um contato específico pelo seu ID.
	 * 
	 * @PathVariable "amarra" a variável {id} da URL ao parâmetro do método. Exemplo
	 *               de acesso: GET /api/contacts/1
	 */

	@GetMapping("/{id}")
	public Contact getContactById(@PathVariable Long id) {
		// findById retorna um Optional, então usamos orElseThrow
		return contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contato não encontrado: " + id));
	}

	/**
	 * @param nome
	 * @return retornará a lista de contatos encontrados que correspondem ao
	 *         pesquisado
	 * 
	 * @RequestParam define que o filtro terá o valor de name (?name=xxx)
	 * 
	 *               O metodo findByNome foi construido no "ContactRepository" como
	 *               um método de busca personalizada
	 */

	@GetMapping("/search")
	public List<Contact> getContactByName(@RequestParam(value = "name") String name) {
		List<Contact> contacts = contactRepository.findByNome(name);

		if (contacts.isEmpty()) {
			return new ArrayList<>();
		}

		return contacts;
	}

	/**
	 * Método para criar um novo contato.
	 * 
	 * @PostMapping indica que este método responde a chamadas HTTP POST.
	 * @RequestBody indica que o objeto Contact será preenchido com os dados JSON
	 *              enviados no corpo da requisição.
	 */
	@PostMapping
	public Contact createContact(@RequestBody Contact contact) {
		return contactRepository.save(contact);
	}

	/**
	 * Método para atualizar um contato existente.
	 * 
	 * @PutMapping indica que este método responde a chamadas HTTP PUT. Exemplo de
	 *             acesso: PUT /api/contacts/1
	 */
	@PutMapping("/{id}")
	public Contact updateContact(@PathVariable Long id, @RequestBody Contact updatedContact) {
		// Buscar o contato existente
		Contact existingContact = contactRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Contato não encontrado: " + id));

		// Atualizar os campos
		existingContact.setNome(updatedContact.getNome());
		existingContact.setTelefone(updatedContact.getTelefone());
		existingContact.setEmail(updatedContact.getEmail());

		// Salvar alterações
		return contactRepository.save(existingContact);
	}

	/**
	 * Método para excluir um contato pelo ID.
	 * 
	 * @DeleteMapping indica que este método responde a chamadas HTTP DELETE.
	 *                Exemplo de acesso: DELETE /api/contacts/1
	 */
	@DeleteMapping("/{id}")
	public void deleteContact(@PathVariable Long id) {
		contactRepository.deleteById(id);
	}

	/**
	 * @param id     :Identifica o cliente que será alterado os dados com ID
	 * @param fields :São campos de Json mapeados (em chave (String) e
	 *               valor(Object))
	 * 
	 *               O metodo de patch usa reflection para encontrar o campo
	 *               correspondente ao que deseja ser modificado. Se o compo é
	 *               encontrado, o valor é atualizado de acordo com o passado.
	 * 
	 */ 
	@PatchMapping("/{id}")
	public Contact updateContactFields(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
		// Buscar o contato existente
		Contact existingContact = contactRepository.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado com o ID: " + id));

		// Atualizar os campos
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Contact.class, key);
			if (field != null) {
				field.setAccessible(true);
				ReflectionUtils.setField(field, existingContact, value);
			}
		});

		return contactRepository.save(existingContact);
	}
}
