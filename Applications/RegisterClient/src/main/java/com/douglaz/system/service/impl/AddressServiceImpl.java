package com.douglaz.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglaz.system.model.Address;
import com.douglaz.system.repository.AddressRepoCustom;
import com.douglaz.system.repository.AddressRepository;
import com.douglaz.system.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	AddressRepoCustom addressRepoCustom;
	
	@Override
	public List<Address> listAll() {
//		return addressRepoCustom.listAll();
		
		return addressRepository.findAll();
	}

}
