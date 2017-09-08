package com.oguzhanmangir.shoppingcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oguzhanmangir.shoppingcart.dao.ICustomerRepository;
import com.oguzhanmangir.shoppingcart.domain.entity.Customer;
import com.oguzhanmangir.shoppingcart.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public void insert(Customer customer) {
		customerRepository.insert(customer);
	}

	@Override
	public Customer find(int id) {
		return customerRepository.find(id);
	}

	@Override
	public void remove(int id) {
		customerRepository.remove(id);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> findByName(String name) {
		return customerRepository.findByName(name);
	}

	@Override
	public Customer login(String userName, String password) {
		return customerRepository.login(userName, password);
	}
}
