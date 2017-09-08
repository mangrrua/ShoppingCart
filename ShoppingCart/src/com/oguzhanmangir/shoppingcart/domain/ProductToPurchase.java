package com.oguzhanmangir.shoppingcart.domain;

import java.math.BigDecimal;

import com.oguzhanmangir.shoppingcart.domain.entity.Product;

/**
 * 
 * @author mangrrua
 *
 */

public class ProductToPurchase {
	
	private Product product;
	private int quantity;
	private BigDecimal price;
	
	public ProductToPurchase() { }

	public ProductToPurchase(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
