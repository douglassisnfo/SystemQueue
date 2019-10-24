package com.douglaz.system.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.douglaz.system.model.Client;

public class ClientSave {
	
	@NotNull
	@NotEmpty
	@Size(min=10,max=50)
	private String name;

	@NotNull
	@NotEmpty
	@Size(min=8,max=50)
	private String password;

	@NotNull
	@NotEmpty
	@Email
	private String email;

	@Valid
	private List<AddressSave> address;
	
	public List<AddressSave> getAddress() {
		return address;
	}

	public void setAddress(List<AddressSave> address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
