package com.douglaz.system.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.douglaz.system.model.enums.Status;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;
	
	private String zipcode;
	
	private String street;
	
	private String neighborhood;
	
	private int number;

	private String city;
	
	private String state;	
	
	private String complement;
	
	private Status status;
		
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}	
	
	
	public Address() {}

	public Address(Builder builder) {
			
		this.zipcode = builder.zipcode;
		this.street = builder.street;
		this.neighborhood = builder.neighborhood;
		this.number = builder.number;
		this.city = builder.city;
		this.state = builder.state;	
		this.complement = builder.complement;
		this.status = builder.status;
		this.client = builder.client;
	}
	
	public static class Builder{
		
		private String zipcode;
		private String street;
		private String neighborhood;
		private int number;
		private String city;
		private String state;	
		private String complement;
		private Status status;
		private Client client;
		
		public Builder wZipCode(String zipcode) {
			this.zipcode=zipcode;
			return this;
		}
		
		public Builder wStreet(String street) {
			this.street=street;
			return this;
		}
		
		public Builder wNeighborhood(String neighborhood) {
			this.neighborhood=neighborhood;
			return this;
		}
		
		public Builder wNumber(int number) {
			this.number=number;
			return this;
		}
		
		public Builder wCity(String city) {
			this.city=city;
			return this;
		}
		
		public Builder wState(String state) {
			this.state=state;
			return this;
		}
		
		public Builder wComplement(String complement) {
			this.complement=complement;
			return this;
		}
		
		public Builder wStatus(Status status) {
			this.status=status;
			return this;
		}
		
		public Builder wClient(Client client) {
			this.client=client;
			return this;
		}
		
		public Address build() {
			return new Address(this);
		}
	}
}
