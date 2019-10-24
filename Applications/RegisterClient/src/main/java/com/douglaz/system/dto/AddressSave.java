package com.douglaz.system.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class AddressSave {
	
	@NotNull
	@NotEmpty
	@Size(min=8,max=9)
	private String zipcode;
	
	@NotNull
	@NotEmpty
	@Size(min=5,max=50)
	private String street;
	
	@NotNull
	@NotEmpty
	@Size(min=5,max=50)
	private String neighborhood;
	
	@PositiveOrZero
	private int number;
	
	@NotNull
	@NotEmpty
	@Size(min=5,max=50)
	private String city;
	
	@NotNull
	@NotEmpty
	@Size(min=5,max=50)
	private String state;	
	
	private String complement;
	
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}
}
