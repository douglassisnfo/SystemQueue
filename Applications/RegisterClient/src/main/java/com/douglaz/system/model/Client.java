package com.douglaz.system.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.douglaz.system.model.enums.Status;

@Entity
public class Client {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	private String name;

	private String password;

	private String email;

	
//	@OneToMany( cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinColumn(name = "clientId")
//	private List<Address> address;
//	
//	public List<Address> getAddress() {
//		return address;
//	}
//
//	public void setAddress(List<Address> address) {
//		this.address = address;
//	}

	private Status status;

	private LocalDate register;

	private LocalDate lastUpdate;

	public Client(UUID id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getRegister() {
		return register;
	}

	public void setRegister(LocalDate register) {
		this.register = register;
	}

	public LocalDate getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDate lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
	 public Client(Builder builder) {
		this.name = builder.name;
		this.password = builder.password;
		this.email = builder.email;
		this.status  = builder.status;
		this.register  = builder.register;
		this.lastUpdate  = builder.lastUpdate;
	}
	
	public static class Builder{
		
		private String name;
		private String password;
		private String email;
		private Status status;
		private LocalDate register;
		private LocalDate lastUpdate;
		
		public Builder wName(String name) {
			this.name=name;
			return this;
		}
		
		public Builder wPassword(String password) {
			this.password=password;
			return this;
		}
		
		public Builder wEmail(String email) {
			this.email=email;
			return this;
		}
		
		public Builder wStatus(Status status) {
			this.status=status;
			return this;
		}
		
		public Builder wRegister(LocalDate register) {
			this.register=register;
			return this;
		}
		
		public Builder wLastUpdate(LocalDate lastUpdate) {
			this.lastUpdate=lastUpdate;
			return this;
		}
		
		public Client build() {
			return new Client(this);
		}
	}
}
