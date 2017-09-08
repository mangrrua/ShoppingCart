package com.oguzhanmangir.shoppingcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhanmangir.shoppingcart.dao.IBrandRepository;
import com.oguzhanmangir.shoppingcart.domain.entity.Brand;
import com.oguzhanmangir.shoppingcart.service.IBrandService;

@Service
public class BrandServiceImpl implements IBrandService{

	@Autowired
	private IBrandRepository brandRepository;

	@Override
	public void insert(Brand brand) {
		brandRepository.insert(brand);
	}

	@Override
	public Brand find(int id) {
		return brandRepository.find(id);
	}

	@Override
	public void remove(int id) {
		brandRepository.remove(id);
	}

	@Override
	public List<Brand> findAll() {
		return brandRepository.findAll();
	}

	@Override
	public Brand findByName(String name) {
		return brandRepository.findByName(name);
	}
}
