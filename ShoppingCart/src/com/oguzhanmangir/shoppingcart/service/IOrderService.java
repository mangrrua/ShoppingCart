package com.oguzhanmangir.shoppingcart.service;

import java.util.List;

import com.oguzhanmangir.shoppingcart.domain.entity.Orders;

public interface IOrderService {

	public void insert(Orders order);
	
	public Orders find(int id);
	
	public void remove(int id);
	
	public List<Orders> findAll();
	
	public List<Orders> findByCustomerId(int id);
}
