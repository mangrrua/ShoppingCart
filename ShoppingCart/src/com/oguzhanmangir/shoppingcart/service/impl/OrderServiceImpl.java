package com.oguzhanmangir.shoppingcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhanmangir.shoppingcart.dao.IOrderRepository;
import com.oguzhanmangir.shoppingcart.domain.entity.Orders;
import com.oguzhanmangir.shoppingcart.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	private IOrderRepository orderRepository;

	@Override
	public void insert(Orders order) {
		orderRepository.insert(order);
	}

	@Override
	public Orders find(int id) {
		return orderRepository.find(id);
	}

	@Override
	public void remove(int id) {
		orderRepository.remove(id);
	}

	@Override
	public List<Orders> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public List<Orders> findByCustomerId(int id) {
		return orderRepository.findByCustomerId(id);
	}
}
