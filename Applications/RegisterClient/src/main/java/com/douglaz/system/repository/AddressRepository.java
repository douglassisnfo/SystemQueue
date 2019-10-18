package com.douglaz.system.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglaz.system.model.Address;

public interface AddressRepository extends JpaRepository<Address, UUID>{

}
