package com.douglaz.system.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.douglaz.system.dto.AddressSave;
import com.douglaz.system.dto.ClientSave;
import com.douglaz.system.dto.ClientWithAddress;
import com.douglaz.system.dto.MessageReturn;
import com.douglaz.system.model.Address;
import com.douglaz.system.model.Client;
import com.douglaz.system.model.enums.Status;
import com.douglaz.system.repository.AddressRepository;
import com.douglaz.system.repository.ClientRepository;
import com.douglaz.system.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Override
	public List<Client> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientWithAddress addressByIdClient(UUID idClient) {
		Optional<Client> optClient =  clientRepository.findById(idClient);
		if(optClient.isPresent()) {
			ClientWithAddress clientWithAddress = new ClientWithAddress(optClient.get());
			clientWithAddress.setAddress(addressRepository.findByClient(optClient.get()));
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
		if(clientRepository.findByEmail(clientSave.getEmail()).isPresent()) {
			return ResponseEntity
		            .status(HttpStatus.CONFLICT)
		            .body("Email já existe na base");
		}else {
			Client client = clientRepository.save(createClient(clientSave));
			saveAddress(clientSave, client);
			
			if(!sendEmail(client)) {
				rolbackSaved(client);
				return ResponseEntity
			            .status(HttpStatus.BAD_REQUEST)
			            .body("Erro ao Criar client ");
			}
			
			return ResponseEntity
		            .status(HttpStatus.CREATED)
		            .body(client);
		}
	}
	
	private void rolbackSaved(Client client) {
		
		addressRepository.deleteAll(addressRepository.findByClient(client));
		clientRepository.delete(client);
	}
	
	/**
	 * Send message to queue 
	 * @param client
	 * @return true message queued or false 
	 */
	private boolean sendEmail(Client client) {
		return true;
	}
	
	/**
	 * save list address
	 * @param clientSave
	 * @param client
	 */
	private void saveAddress(ClientSave clientSave, Client client) {
		clientSave.getAddress().forEach(addressSave -> {
			addressRepository.save(createAddress(addressSave, client));
		});
	}
	
	private Client createClient(ClientSave clientSave) {
		return new Client.Builder()
				.wName(clientSave.getName())
				.wPassword(clientSave.getPassword())
				.wEmail(clientSave.getEmail())
				.wStatus(Status.Inactive)
				.wRegister(LocalDate.now())
				.wLastUpdate(LocalDate.now())
				.build();
	}
	
	private Address createAddress(AddressSave addressSave, Client client) {
		return new Address.Builder()
			.wZipCode(addressSave.getZipcode())
			.wStreet(addressSave.getStreet())
			.wNumber(addressSave.getNumber())
			.wNeighborhood(addressSave.getNeighborhood())
			.wCity(addressSave.getCity())
			.wState(addressSave.getState())
			.wComplement((addressSave.getComplement() == null)? null : addressSave.getComplement())
			.wStatus(Status.Active)
			.wClient(client)
			.build();
	}
}
