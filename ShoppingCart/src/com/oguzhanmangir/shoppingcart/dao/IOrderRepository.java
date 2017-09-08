package com.oguzhanmangir.shoppingcart.dao;

import java.util.List;

import com.oguzhanmangir.shoppingcart.domain.entity.Orders;

public interface IOrderRepository {

	public void insert(Orders order);
	
	public Orders find(int id);
	
	public void remove(int id);
	
	public List<Orders> findAll();
	
	public List<Orders> findByCustomerId(int id);
	
}
