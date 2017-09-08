package com.oguzhanmangir.shoppingcart.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.oguzhanmangir.shoppingcart.dao.IBrandRepository;
import com.oguzhanmangir.shoppingcart.domain.entity.Brand;

@Repository
public class BrandRepositoryImpl implements IBrandRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(Brand brand) {
		entityManager.persist(brand);
	}

	@Override
	public Brand find(int id) {
		return entityManager.find(Brand.class, id);
	}

	@Override
	public void remove(int id) {
		Brand brand = find(id);
		
		if(brand != null){
			entityManager.remove(brand);
		}
	}

	@Override
	public List<Brand> findAll() {
		TypedQuery<Brand> query = entityManager.createQuery("select e from Brand e", Brand.class);
		return query.getResultList();
	}

	@Override
	public Brand findByName(String name) {
		TypedQuery<Brand> query = entityManager.createQuery("select e from Brand e where "
				+ "e.name = :name", Brand.class)
				.setParameter("name", name);
		
		return query.getSingleResult();
	}

}
