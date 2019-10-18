package com.douglaz.system.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	@OneToMany(mappedBy="client")
	private List<Address> address;
	
	private Status status;
	
	private LocalDate register;
	
	private LocalDate lastUpdate;
	
}
