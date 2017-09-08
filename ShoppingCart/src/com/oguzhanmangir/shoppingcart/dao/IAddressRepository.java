package com.oguzhanmangir.shoppingcart.dao;

import java.util.List;

import com.oguzhanmangir.shoppingcart.domain.entity.Address;


public interface IAddressRepository {
	
	public void insert(Address address);
	
	public Address find(int id);
	
	public void remove(int id);
	
	public List<Address> findAll();
	

}
