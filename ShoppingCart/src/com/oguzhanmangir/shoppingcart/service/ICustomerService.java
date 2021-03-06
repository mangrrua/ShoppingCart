package com.oguzhanmangir.shoppingcart.service;

import java.util.List;

import com.oguzhanmangir.shoppingcart.domain.entity.Customer;

public interface ICustomerService {
	
	public void insert(Customer customer);
	
	public Customer find(int id);
	
	public void remove(int id);

	public List<Customer> findAll();
	
	public List<Customer> findByName(String name);
	
	// for login
	public Customer login(String userName, String password);

}
