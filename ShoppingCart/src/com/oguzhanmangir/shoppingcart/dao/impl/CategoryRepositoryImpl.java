package com.oguzhanmangir.shoppingcart.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.oguzhanmangir.shoppingcart.dao.ICategoryRepository;
import com.oguzhanmangir.shoppingcart.domain.entity.Category;

@Repository
public class CategoryRepositoryImpl implements ICategoryRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(Category category) {
		entityManager.persist(category);
	}

	@Override
	public Category find(int id) {
		return entityManager.find(Category.class, id);
	}

	@Override
	public void remove(int id) {
		Category category = find(id);
		
		if(category != null){
			entityManager.remove(category);
		}
	}

	@Override
	public List<Category> findAll() {
		TypedQuery<Category> query = entityManager.createQuery("select e from Category e", Category.class);
		return query.getResultList();
	}

	@Override
	public Category findByName(String name) {
		TypedQuery<Category> query = entityManager.createQuery("select e from Category e where "
				+ "e.name = :name", Category.class)
				.setParameter("name", name);
		
		return query.getSingleResult();
	}
}
