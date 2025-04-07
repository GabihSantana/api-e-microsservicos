package br.ifsp.contacts.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifsp.contacts.model.Address;

/**
 * A interface estende JpaRepository<Address, Long>, 
 * o que significa que herda todos os métodos básicos de manipulação 
 * (save(), delete(), findById(), etc.).
 */

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
	// recuperar endereços associados a um contato específico
    //List<Address> findByContactId(Long contactId);
    Page<Address> findByContactId(Long contactId, Pageable pageable);
}
