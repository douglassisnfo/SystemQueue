package com.douglaz.system.dto;

import java.util.List;
import java.util.UUID;

import com.douglaz.system.model.Address;
import com.douglaz.system.model.Client;

public class ClientWithAddress extends Client{

	public ClientWithAddress(UUID id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * I need to set all data
	 * @param client
	 */
	public ClientWithAddress(Client client) {
		this.setId(client.getId());
		this.setName(client.getName());
	}

	private List<Address> address;
	
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
}
