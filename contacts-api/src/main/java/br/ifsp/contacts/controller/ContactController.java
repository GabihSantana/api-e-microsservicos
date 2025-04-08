package br.ifsp.contacts.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ifsp.contacts.dto.address.AddressResponseDTO;
import br.ifsp.contacts.dto.contact.ContactPatchDTO;
import br.ifsp.contacts.dto.contact.ContactRequestDTO;
import br.ifsp.contacts.dto.contact.ContactResponseDTO;
import br.ifsp.contacts.exception.ResourceNotFoundException;
import br.ifsp.contacts.model.Address;
import br.ifsp.contacts.model.Contact;
import br.ifsp.contacts.repository.ContactRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

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
@Tag(name = "Contatos", description = "Operações relacionadas a contatos")
@Validated
public class ContactController {

	/**
	 * @Autowired permite que o Spring "injete" automaticamente uma instância de
	 *            ContactRepository aqui, sem que precisemos criar manualmente.
	 */
	
	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Método para obter todos os contatos.
	 * 
	 * @GetMapping indica que este método vai responder a chamadas HTTP GET. Exemplo
	 *             de acesso: GET /api/contacts
	 */
	
    @Operation(summary = "Buscar todos os contatos paginados")
	@GetMapping
	public Page<ContactResponseDTO> getAllContacts(Pageable pageable) {
		return contactRepository.findAll(pageable).map(contact -> modelMapper.map(contact, ContactResponseDTO.class));
	}

	/**
	 * Método para obter um contato específico pelo seu ID.
	 * 
	 * @PathVariable "amarra" a variável {id} da URL ao parâmetro do método. Exemplo
	 *               de acesso: GET /api/contacts/1
	 */

    @Operation(summary = "Buscar contatos por ID")
	@GetMapping("/{id}")
	public ContactResponseDTO getContactById(@PathVariable Long id) {
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado: " + id));
		return modelMapper.map(contact, ContactResponseDTO.class);
	}
    
    @Operation(summary = "Buscar os endereços do cliente via ID")
	@GetMapping("/{id}/addresses")
	public List<AddressResponseDTO> getContactAddressesById(@PathVariable Long id, Pageable pegeable) {
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Contato não encontrado: " + id));

		return contact.getAddresses().stream() // stream pois lista nao tem .map
				.map(address -> modelMapper.map(address, AddressResponseDTO.class)) // mapeia cada Addr para DTO
				.collect(Collectors.toList()); // converte de volta para lista

	}

	/**
	 * @param nome
	 * @return retornará a lista de contatos encontrados que correspondem ao
	 *         pesquisado
	 * 
	 * @RequestParam define que o filtro terá o valor de name (?name=xxx)
	 * 
	 *               O metodo findByNomeContainingIgnoreCase foi construido no
	 *               "ContactRepository" como um método de busca personalizada
	 * 
	 *               o findBy indica que será realizado uma busca, containing contém
	 *               tipo LIKE %t% em SQL, ignorando a diferença de caracteres
	 *               (Lower or Upper case)
	 */

    @Operation(summary = "Buscar os clientes pelo nome")
	@GetMapping("/search")
	public Page<ContactResponseDTO> getContactByName(@RequestParam String name, Pageable pageable) {
		return contactRepository.findByNomeContainingIgnoreCase(name, pageable)
				.map(contact -> modelMapper.map(contact, ContactResponseDTO.class));
	}

	/**
	 * Método para criar um novo contato.
	 * 
	 * @PostMapping indica que este método responde a chamadas HTTP POST.
	 * @RequestBody indica que o objeto Contact será preenchido com os dados JSON
	 *              enviados no corpo da requisição.
	 */

    @Operation(summary = "Criar um novo contato")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ContactResponseDTO createContact(@RequestBody @Valid ContactRequestDTO contactRequestDTO) {
		// Mapeia os campos simples
		Contact contact = new Contact(contactRequestDTO.getNome(), contactRequestDTO.getTelefone(), contactRequestDTO.getEmail());

        // Mapeia os endereços manualmente
		var addresses = contactRequestDTO.getAddresses().stream()
			    .map(addrDto -> {
			        Address address = new Address();
			        address.setRua(addrDto.getRua());
			        address.setCidade(addrDto.getCidade());
			        address.setEstado(addrDto.getEstado());
			        address.setCep(addrDto.getCep());
			        address.setContact(contact); 
			        return address;
			    }).toList();
		
		contact.setAddresses(addresses);
		
		Contact savedContact = contactRepository.save(contact);
		// Converte a entidade salva para DTO de resposta
		
		return modelMapper.map(savedContact, ContactResponseDTO.class);
	}

	/**
	 * Método para atualizar um contato existente.
	 * 
	 * @PutMapping indica que este método responde a chamadas HTTP PUT. Exemplo de
	 *             acesso: PUT /api/contacts/1
	 */
    
    @Operation(summary = "Atualizar o cliente via ID")
	@PutMapping("/{id}")
	public ContactResponseDTO updateContact(@PathVariable Long id,
			@RequestBody @Valid ContactRequestDTO contactRequestDTO) {
		// Buscar o contato existente
		Contact existingContact = contactRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Contato não encontrado: " + id));

		// Converte o DTO para entidade
		Contact contact = modelMapper.map(contactRequestDTO, Contact.class);

		// Atualizar os campos
		existingContact.setNome(contact.getNome());
		existingContact.setTelefone(contact.getTelefone());
		existingContact.setEmail(contact.getEmail());

		// Salvar alterações
		Contact savedContact = contactRepository.save(existingContact);

		// retorna DTO de resposta com os dados atualizados
		return modelMapper.map(savedContact, ContactResponseDTO.class);
	}

	/**
	 * Método para excluir um contato pelo ID.
	 * 
	 * @DeleteMapping indica que este método responde a chamadas HTTP DELETE.
	 *                Exemplo de acesso: DELETE /api/contacts/1
	 */
    @Operation(summary = "Deletar o cliente pelo ID")
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
    @Operation(summary = "Atualizar parcialmente o cliente")
	@PatchMapping("/{id}")
	public ContactResponseDTO updateContactFields(@PathVariable Long id,
			@RequestBody @Valid ContactPatchDTO contactPatchDTO) {
		// Buscar o contato existente
		Contact existingContact = contactRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado com o ID: " + id));

		// Atualizar apenas os campos que estiverem presentes no DTO
		contactPatchDTO.getNome().ifPresent(existingContact::setNome);
		contactPatchDTO.getEmail().ifPresent(existingContact::setEmail);
		contactPatchDTO.getTelefone().ifPresent(existingContact::setTelefone);

		Contact savedContact = contactRepository.save(existingContact);
		return modelMapper.map(savedContact, ContactResponseDTO.class);
	}
}
