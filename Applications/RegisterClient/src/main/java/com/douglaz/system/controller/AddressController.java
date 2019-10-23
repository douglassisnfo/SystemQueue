package com.douglaz.system.controller;

import java.net.UnknownHostException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglaz.system.model.Address;
import com.douglaz.system.repository.AddressRepoCustom;
import com.douglaz.system.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	Logger logger = LoggerFactory.getLogger(Hello.class);
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	AddressRepoCustom addressRepoCustom;
	
	@GetMapping("/all")
	public List<Address> get() throws UnknownHostException {
		logger.trace("Acesso aos dados  - address");
		return addressRepoCustom.listAll();
	}
}
