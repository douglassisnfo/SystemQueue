package com.douglaz.system.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglaz.system.model.Client;

public interface ClientRepository extends JpaRepository<Client, UUID>{

}
