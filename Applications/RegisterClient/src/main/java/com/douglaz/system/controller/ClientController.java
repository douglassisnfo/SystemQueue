package com.douglaz.system.controller;

import java.net.UnknownHostException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglaz.system.model.Client;
import com.douglaz.system.repository.ClientRepoCustom;
import com.douglaz.system.repository.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	Logger logger = LoggerFactory.getLogger(Hello.class);
	@Autowired
	ClientRepoCustom clientRepoCustom;
	
	@GetMapping("/all")
	public List<Client> get() throws UnknownHostException {
		
		logger.trace("Acesso aos dados  - client ");
		
		return clientRepoCustom.listAll();
	}


}
