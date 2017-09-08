package com.oguzhanmangir.shoppingcart.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.oguzhanmangir.shoppingcart.dao.IAdminRepository;
import com.oguzhanmangir.shoppingcart.domain.entity.Admin;

@Repository
public class AdminRepositoryImpl implements IAdminRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Admin login(String userName, String password) {
		TypedQuery<Admin> query = entityManager.createQuery("select e from Admin e where "
				+ "e.userName = :userName and "
				+ "e.password = :password", Admin.class)
				.setParameter("userName", userName)
				.setParameter("password", password);
		
		return query.getSingleResult();
	}

	
}
