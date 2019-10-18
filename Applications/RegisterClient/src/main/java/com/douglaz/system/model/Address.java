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
	
	@ManyToOne
	@JoinColumn(name="clienId")
	private Client client;
}
