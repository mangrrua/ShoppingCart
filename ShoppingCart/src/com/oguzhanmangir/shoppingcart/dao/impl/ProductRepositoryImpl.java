package com.oguzhanmangir.shoppingcart.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.oguzhanmangir.shoppingcart.dao.IProductRepository;
import com.oguzhanmangir.shoppingcart.domain.entity.Product;

@Repository
public class ProductRepositoryImpl implements IProductRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insert(Product product) {
		entityManager.persist(product);
	}

	@Override
	public Product find(int id) {
		return entityManager.find(Product.class, id);
	}

	@Override
	public void remove(int id) {
		Product product = find(id);
		
		if(product != null){
			entityManager.remove(product);
		}
	}

	@Override
	public List<Product> findAll() {
		TypedQuery<Product> query = entityManager.createQuery("select e from Product e", Product.class);
		return query.getResultList();
	}

	@Override
	public List<Product> findByName(String name) {
		TypedQuery<Product> query = entityManager.createQuery("select e from Product e where "
				+ "lower(e.name) = lower(:name)", Product.class)
				.setParameter("name", name);
		
		return query.getResultList();
	}

	@Override
	public List<Product> findByCategory(String category) {
		TypedQuery<Product> query = entityManager.createQuery("select e from Product e where "
				+ "lower(e.category.name) = lower(:name)", Product.class)
				.setParameter("name", category);
		
		return query.getResultList();
	}

	@Override
	public List<Product> findByBrand(String brand) {
		TypedQuery<Product> query = entityManager.createQuery("select e from Product e where "
				+ "lower(e.brand.name) = lower(:name)", Product.class)
				.setParameter("name", brand);
		
		return query.getResultList();
	}

	@Override
	public List<Product> findByBrandAndCategory(String brand, String category) {
		TypedQuery<Product> query = entityManager.createQuery("select e from Product e where "
				+ "lower(e.brand.name) = lower(:brand) and "
				+ "lower(e.category.name) = lower(:category)", Product.class)
				.setParameter("brand", brand)
				.setParameter("category", category);
		
		return query.getResultList();
	}
}
