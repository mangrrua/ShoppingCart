package com.oguzhanmangir.shoppingcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhanmangir.shoppingcart.dao.IAddressRepository;
import com.oguzhanmangir.shoppingcart.domain.entity.Address;
import com.oguzhanmangir.shoppingcart.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService{

	@Autowired
	private IAddressRepository addressRepository;

	@Override
	public void insert(Address address) {
		addressRepository.insert(address);
	}

	@Override
	public Address find(int id) {
		return addressRepository.find(id);
	}

	@Override
	public void remove(int id) {
		addressRepository.remove(id);
	}

	@Override
	public List<Address> findAll() {
		return addressRepository.findAll();
	}
}
