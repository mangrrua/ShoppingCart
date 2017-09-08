package com.oguzhanmangir.shoppingcart.service;

import java.util.List;

import com.oguzhanmangir.shoppingcart.domain.entity.Category;

public interface ICategoryService {

	public void insert(Category category);
	
	public Category find(int id);
	
	public void remove(int id);
	
	public List<Category> findAll();
	
	public Category findByName(String name);
}
