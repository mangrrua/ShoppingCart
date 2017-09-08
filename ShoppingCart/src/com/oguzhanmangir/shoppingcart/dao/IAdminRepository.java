package com.oguzhanmangir.shoppingcart.dao;

import com.oguzhanmangir.shoppingcart.domain.entity.Admin;

public interface IAdminRepository {

	public Admin login(String userName, String password);
}
