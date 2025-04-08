package br.ifsp.contacts.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ifsp.contacts.dto.address.AddressResponseDTO;
import br.ifsp.contacts.exception.ResourceNotFoundException;
import br.ifsp.contacts.model.Address;
import br.ifsp.contacts.model.Contact;
import br.ifsp.contacts.repository.AddressRepository;
import br.ifsp.contacts.repository.ContactRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Controlador REST responsável por manipular as requisições HTTP
 * @RestController indica que seus métodos retornarão dados diretamente no corpo da resposta (em formato JSON)
 * @RequestMapping define o caminho base para todos os endpoints dentro deste controlador
 */

@RestController
@RequestMapping("/api/addresses")
@Tag(name = "Address", description = "Operações relacionadas a endereço")
@Validated
public class AddressController {
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
    @Autowired
    private ContactRepository contactRepository;
	
    @Operation(summary = "Criar um novo endereço a um contato existente")
    @PostMapping("/contacts/{contactId}")
    /**
     * @ResponseStatus indica que se o endereço for salvo com sucesso, o servidor retornará um código HTTP 201 (Created)
     */
    @ResponseStatus(HttpStatus.CREATED)
    public Address createAddress(@PathVariable Long contactId, @RequestBody @Valid Address address) {
    	 Contact contact = contactRepository.findById(contactId)
                 .orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado: " + contactId));
    	 
    	 address.setContact(contact);
         return addressRepository.save(address);
	}
	
    @Operation(summary = "Buscar todos os endereços")
	@GetMapping
	public List<Address> getAllAddress() {
		return addressRepository.findAll();
	}
	
    @Operation(summary = "Buscar todos os endereços pelo ID do contato")
    @GetMapping("/contacts/{contactId}")
    public Page<AddressResponseDTO> getAddressesByContact(@PathVariable Long contactId, Pageable pageable) {
        return addressRepository.findByContactId(contactId, pageable)
                .map(address -> modelMapper.map(address, AddressResponseDTO.class));
    }
	
}
