package com.oguzhanmangir.shoppingcart.domain;

import java.math.BigDecimal;

public interface IPayment {
	
	public BigDecimal getAmount();
	
	public String getCustomerName();

	

}
