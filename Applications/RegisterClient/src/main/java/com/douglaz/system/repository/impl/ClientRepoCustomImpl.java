package com.douglaz.system.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.douglaz.system.model.Client;
import com.douglaz.system.repository.ClientRepoCustom;

@Repository
public class ClientRepoCustomImpl implements ClientRepoCustom{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Client> listAll() {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Client> criteriaQuery = builder.createQuery(Client.class);
	     
	    Root<Client> client= criteriaQuery.from(Client.class);
	    client.fetch("address");
	    criteriaQuery.select(client);
	 
	    TypedQuery<Client> query = entityManager.createQuery(criteriaQuery);
	    return query.getResultList();
	}

}
