package com.douglaz.system.repository.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.douglaz.system.model.Address;
import com.douglaz.system.repository.AddressRepoCustom;
import com.douglaz.system.repository.AddressRepository;

@Repository
public class AddressRepoCustomImpl implements AddressRepoCustom {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Address> listAll() {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Address> criteriaQuery = builder.createQuery(Address.class);
	     
	    Root<Address> address = criteriaQuery.from(Address.class);
	   // address.fetch("client");
	    criteriaQuery.select(address);
	 
	    TypedQuery<Address> query = entityManager.createQuery(criteriaQuery);
	    return query.getResultList();
	}

}
