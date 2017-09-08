package com.oguzhanmangir.shoppingcart.service;

import java.util.List;

import com.oguzhanmangir.shoppingcart.domain.entity.Product;

public interface IProductService {

	public void insert(Product product);
	
	public Product find(int id);
	
	public void remove(int id);
	
	public List<Product> findAll();
	
	public List<Product> findByName(String name);
	
	public List<Product> findByCategory(String category);
	
	public List<Product> findByBrand(String brand);
	
	public List<Product> findByBrandAndCategory(String brand, String category);
}
