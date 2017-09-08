package com.oguzhanmangir.shoppingcart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhanmangir.shoppingcart.dao.IAdminRepository;
import com.oguzhanmangir.shoppingcart.domain.entity.Admin;
import com.oguzhanmangir.shoppingcart.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	private IAdminRepository adminRepository;

	@Override
	public Admin login(String userName, String password) {
		return adminRepository.login(userName, password);
	}
}
