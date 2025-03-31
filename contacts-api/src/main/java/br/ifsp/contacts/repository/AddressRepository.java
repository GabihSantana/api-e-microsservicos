package br.ifsp.contacts.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsp.contacts.model.Address;

/**
 * A interface estende JpaRepository<Address, Long>, 
 * o que significa que herda todos os métodos básicos de manipulação 
 * (save(), delete(), findById(), etc.).
 */

public interface AddressRepository extends JpaRepository<Address, Long>{
	// recuperar endereços associados a um contato específico
    List<Address> findByContactId(Long contactId);
}
