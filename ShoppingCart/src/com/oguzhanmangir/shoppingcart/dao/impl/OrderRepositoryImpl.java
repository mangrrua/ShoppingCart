package com.oguzhanmangir.shoppingcart.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.oguzhanmangir.shoppingcart.dao.IOrderRepository;
import com.oguzhanmangir.shoppingcart.domain.entity.Orders;

@Repository
public class OrderRepositoryImpl implements IOrderRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insert(Orders order) {
		entityManager.persist(order);
	}

	@Override
	public Orders find(int id) {
		return entityManager.find(Orders.class, id);
	}

	@Override
	public void remove(int id) {
		Orders order = find(id);
		
		if(order != null){
			entityManager.remove(order);
		}
	}

	@Override
	public List<Orders> findAll() {
		TypedQuery<Orders> query = entityManager.createQuery("select e from Orders e", Orders.class);
		return query.getResultList();
	}

	@Override
	public List<Orders> findByCustomerId(int id) {
		TypedQuery<Orders> query = entityManager.createQuery("select e from Orders e where "
				+ "e.customer.id = :id", Orders.class)
				.setParameter("id", id);
		
		return query.getResultList();
	}
}
