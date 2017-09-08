package com.oguzhanmangir.shoppingcart.service;

import com.oguzhanmangir.shoppingcart.domain.entity.Admin;

public interface IAdminService {

	public Admin login(String userName, String password);
}
