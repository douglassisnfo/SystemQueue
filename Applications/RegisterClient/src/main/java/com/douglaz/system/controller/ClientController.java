package com.douglaz.system.controller;

import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglaz.system.dto.ClientWithAddress;
import com.douglaz.system.model.Address;
import com.douglaz.system.model.Client;
import com.douglaz.system.repository.AddressRepository;
import com.douglaz.system.repository.ClientRepoCustom;
import com.douglaz.system.repository.ClientRepository;
import com.douglaz.system.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	Logger logger = LoggerFactory.getLogger(Hello.class);
	
	@Autowired
	ClientRepoCustom clientRepoCustom;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	ClientService clientService;
	
	@GetMapping("/all")
	public List<Client> get() throws UnknownHostException {
		
		logger.trace("Acesso aos dados  - client ");
		return clientRepository.findAll();
	}
	
	@GetMapping("/{id}/address")
	public List<Address> addressByIdClient(@PathVariable @Required String id ) throws UnknownHostException {
		logger.trace("Acesso address  - client ");
		return addressRepository.findByClient(new Client(UUID.fromString(id)));
	}
	
	@GetMapping("/{id}")
	public ClientWithAddress addressByIdClien2(@PathVariable @Required String id ) throws UnknownHostException {
		logger.trace("Acesso address  - client ");
		return clientService.addressByIdClient(UUID.fromString(id));
	}


}
