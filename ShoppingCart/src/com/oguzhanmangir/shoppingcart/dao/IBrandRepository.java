package com.oguzhanmangir.shoppingcart.dao;

import java.util.List;

import com.oguzhanmangir.shoppingcart.domain.entity.Brand;

public interface IBrandRepository {
	
	public void insert(Brand brand);
	
	public Brand find(int id);
	
	public void remove(int id);
	
	public List<Brand> findAll();
	
	public Brand findByName(String name);

}
