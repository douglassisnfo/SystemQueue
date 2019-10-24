package com.douglaz.system.controller;

import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import javax.validation.Valid;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.douglaz.system.dto.ClientSave;
import com.douglaz.system.dto.ClientWithAddress;
import com.douglaz.system.dto.MessageReturn;
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
	
	@PostMapping
    public ResponseEntity saveClient(@Valid @RequestBody ClientSave clientSave, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
        	logger.trace( "DADOS INVÁLIDOS - VALOR {0}", clientSave.toString());
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageReturn.errorFields(bindingResult));
        }

        return clientService.saveClient(clientSave);
    }
	
}
