package com.oguzhanmangir.shoppingcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhanmangir.shoppingcart.dao.ICategoryRepository;
import com.oguzhanmangir.shoppingcart.domain.entity.Category;
import com.oguzhanmangir.shoppingcart.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public void insert(Category category) {
		categoryRepository.insert(category);
	}

	@Override
	public Category find(int id) {
		return categoryRepository.find(id);
	}

	@Override
	public void remove(int id) {
		categoryRepository.remove(id);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	}
}
