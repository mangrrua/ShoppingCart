package com.oguzhanmangir.shoppingcart.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.oguzhanmangir.shoppingcart.dao.IAddressRepository;
import com.oguzhanmangir.shoppingcart.domain.entity.Address;

@Repository
public class AddressRepositoryImpl implements IAddressRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insert(Address address) {
		entityManager.persist(address);
	}

	@Override
	public Address find(int id) {
		return entityManager.find(Address.class, id);
	}

	@Override
	public void remove(int id) {
		Address address = find(id);
		
		if(address != null){
			entityManager.remove(address);
		}
	}

	@Override
	public List<Address> findAll() {
		TypedQuery<Address> query = entityManager.createQuery("select e from Address e", Address.class);
		return query.getResultList();
	}
}
