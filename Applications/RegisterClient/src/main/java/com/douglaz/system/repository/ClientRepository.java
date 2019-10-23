package com.douglaz.system.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douglaz.system.model.Address;
import com.douglaz.system.model.Client;

public interface ClientRepository extends JpaRepository<Client, UUID>{
	
	//@Query(value = "Select c FROM client c join fetch c.address ")
	//List<Client> findAll();
	
	Optional<Client> findById(UUID id);
}
