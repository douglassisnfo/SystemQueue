package com.douglaz.system.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.douglaz.system.dto.ClientSave;
import com.douglaz.system.dto.ClientWithAddress;
import com.douglaz.system.dto.MessageReturn;
import com.douglaz.system.model.Client;
import com.douglaz.system.repository.AddressRepository;
import com.douglaz.system.repository.ClientRepository;
import com.douglaz.system.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository ClientRepository;
	
	@Autowired
	AddressRepository AddressRepository;
	
	@Override
	public List<Client> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientWithAddress addressByIdClient(UUID idClient) {
		Optional<Client> optClient =  ClientRepository.findById(idClient);
		if(optClient.isPresent()) {
			ClientWithAddress clientWithAddress = new ClientWithAddress(optClient.get());
			clientWithAddress.setAddress(AddressRepository.findByClient(optClient.get()));
			return clientWithAddress;
		}
		
		return null;
	}
	
	/**
	 * check email exists
	 * set registerDate
	 * set status as inactive
	 * set lastUpdate equal registerDate
	 * save client
	 * send message activation
	 */
	@Override
	public ResponseEntity saveClient(ClientSave clientSave) {
		if(ClientRepository.findByEmail(clientSave.getEmail()).isPresent()) {
			return ResponseEntity
		            .status(HttpStatus.CONFLICT)
		            .body("Email já existe na base");
		}
		return null;
	}
	
	
}
