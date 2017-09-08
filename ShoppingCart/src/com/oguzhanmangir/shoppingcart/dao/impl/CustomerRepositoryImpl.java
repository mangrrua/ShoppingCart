package com.oguzhanmangir.shoppingcart.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.oguzhanmangir.shoppingcart.dao.ICustomerRepository;
import com.oguzhanmangir.shoppingcart.domain.entity.Customer;

@Repository
public class CustomerRepositoryImpl implements ICustomerRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insert(Customer customer) {
		entityManager.persist(customer);
	}

	@Override
	public Customer find(int id) {
		return entityManager.find(Customer.class, id);
	}

	@Override
	public void remove(int id) {
		Customer customer = find(id);
		
		if(customer != null){
			entityManager.remove(customer);
		}
	}

	@Override
	public List<Customer> findAll() {
		TypedQuery<Customer> query = entityManager.createQuery("select e from Customer e", Customer.class);
		return query.getResultList();
	}

	@Override
	public List<Customer> findByName(String name) {
		TypedQuery<Customer> query = entityManager.createQuery("select e from Customer e where "
				+ "e.name = :name", Customer.class)
				.setParameter("name", name);
		
		return query.getResultList();
	}

	@Override
	public Customer login(String userName, String password) {
		try {
			return entityManager.createQuery("select e from Customer e where "
					+ "e.userName = :userName and "
					+ "e.password = :password", Customer.class)
					.setParameter("userName", userName)
					.setParameter("password", password).getSingleResult();
		} catch (Exception e) {
			return null;
		}		
	}

}
