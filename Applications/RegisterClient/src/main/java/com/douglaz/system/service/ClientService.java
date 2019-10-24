package com.douglaz.system.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.douglaz.system.dto.ClientSave;
import com.douglaz.system.dto.ClientWithAddress;
import com.douglaz.system.model.Client;

public interface ClientService {
	
	List<Client>listAll();
	
	ClientWithAddress addressByIdClient(UUID idClient);

	ResponseEntity saveClient(ClientSave clientSave);
	
}
