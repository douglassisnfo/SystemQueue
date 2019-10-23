package com.douglaz.system.service;

import java.util.List;
import java.util.UUID;

import com.douglaz.system.dto.ClientWithAddress;
import com.douglaz.system.model.Client;

public interface ClientService {
	
	List<Client>listAll();
	
	ClientWithAddress addressByIdClient(UUID idClient);
}
