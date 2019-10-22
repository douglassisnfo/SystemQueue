package com.douglaz.system.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douglaz.system.model.Address;

public interface AddressRepository extends JpaRepository<Address, UUID>{
	
	
}
