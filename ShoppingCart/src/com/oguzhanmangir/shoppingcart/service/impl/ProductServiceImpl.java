package com.oguzhanmangir.shoppingcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhanmangir.shoppingcart.dao.IProductRepository;
import com.oguzhanmangir.shoppingcart.domain.entity.Product;
import com.oguzhanmangir.shoppingcart.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private IProductRepository productRepository;

	@Override
	public void insert(Product product) {
		productRepository.insert(product);
	}

	@Override
	public Product find(int id) {
		return productRepository.find(id);
	}

	@Override
	public void remove(int id) {
		productRepository.remove(id);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> findByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public List<Product> findByCategory(String category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public List<Product> findByBrand(String brand) {
		return productRepository.findByBrand(brand);
	}

	@Override
	public List<Product> findByBrandAndCategory(String brand, String category) {
		return productRepository.findByBrandAndCategory(brand, category);
	}	
}
