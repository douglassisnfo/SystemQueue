package com.douglaz.system.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.douglaz.system.dto.AddressSave;
import com.douglaz.system.dto.ClientSave;
import com.douglaz.system.dto.ClientWithAddress;
import com.douglaz.system.model.Address;
import com.douglaz.system.model.Client;
import com.douglaz.system.repository.AddressRepository;
import com.douglaz.system.repository.ClientRepository;
import com.douglaz.system.service.impl.ClientServiceImpl;

@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ClientServiceImpl.class})
public class ClientServiceTest {
	
	@MockBean
	AddressRepository addressRepository;
	
	@MockBean
	ClientRepository clientRepository;
	
	@Autowired
	ClientService clientService;
	
	private Client createClient() {
		Client client = new Client(UUID.randomUUID());
		client.setName("Douglas");
		client.setPassword("1234567890");
		client.setEmail("douglas@gmail.com");
		return client;
	}
	
	private Address createAddress() {
		Random gerador = new Random();
		String city = (gerador.nextInt() == 0) ? 
                "São Paulo" : "Suzano";
		
		Address address = new Address();
		address.setId(UUID.randomUUID());
		address.setNumber(gerador.nextInt(1));
		address.setCity(city);
		return address;
	}
	
	private List<Address> createListAddress(){
		return Arrays.asList(createAddress(),createAddress());
	}
	
	
	private ClientSave createClientSave() {
		ClientSave client = new ClientSave();
		client.setName("Douglas");
		client.setPassword("1234567890");
		client.setEmail("douglas@gmail.com");
		client.setAddress(Arrays.asList(createAddressSave()));
		return client;
	}
	
	private AddressSave createAddressSave() {
		Random gerador = new Random();
		
		String city = (gerador.nextInt() == 0) ? 
                "São Paulo" : "Suzano";
		
		AddressSave address = new AddressSave();
		address.setZipcode("03320589");
		address.setStreet("Rua Maria Jose");
		address.setNeighborhood("Bairro da Saudade");
		address.setState("São Paulo");	
		address.setNumber(gerador.nextInt(1));
		address.setCity(city);
		return address;
	}
	
	@Before
	public void setUp() {
		
		 Mockito.when(clientRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.of(createClient()));
		 
		 Mockito.when(addressRepository.findByClient(Mockito.any(Client.class))).thenReturn(createListAddress());
	}
	
	@Test
	public void addressByIdClient() {
		
		ClientWithAddress client = clientService.addressByIdClient(UUID.randomUUID());
		String name = "Douglas";
		assertThat(client.getAddress().size()).isEqualTo(2);
		assertThat(client.getName()).isEqualTo(name);
	}
	
	@Test
	public void saveClientEmailAlreadyExists() {
		 
		Mockito.when(clientRepository.findByEmail(Mockito.any(String.class))).thenReturn(Optional.of(createClient()));
		ResponseEntity responseEntity = clientService.saveClient(createClientSave());
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
	} 
	
	

}
