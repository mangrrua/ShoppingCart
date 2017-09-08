package com.oguzhanmangir.shoppingcart.domain;

import java.math.BigDecimal;
import java.util.Map;

import com.oguzhanmangir.shoppingcart.domain.entity.Product;

public class ShoppingCart {

	private Product product;
	private BigDecimal totalPrice;
	private int totalQuantity;
	private BigDecimal discount;
	private Map<Integer, ProductToPurchase> sCart;

	
	private ShoppingCart(ShoppingCartBuilder builder){
		this.product = builder.product;
		this.totalPrice = builder.totalPrice;
		this.totalQuantity = builder.totalQuantity;
		this.discount = builder.discount;
		this.sCart = builder.sCart;
	}

	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}


	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Map<Integer, ProductToPurchase> getsCart() {
		return sCart;
	}

	public void setsCart(Map<Integer, ProductToPurchase> sCart) {
		this.sCart = sCart;
	}

	// shopping cart builder
	public static class ShoppingCartBuilder {
		private Map<Integer, ProductToPurchase> sCart;
		private Product product;
		private BigDecimal totalPrice;
		private int totalQuantity;
		private BigDecimal discount;
		
		// constructor
		public ShoppingCartBuilder(Map<Integer, ProductToPurchase> sCart){
			this.sCart = sCart;
		}

		public ShoppingCartBuilder sCart(Map<Integer, ProductToPurchase> sCart){
			this.sCart = sCart;
			return this;
		}
		
		public ShoppingCartBuilder totalPrice(BigDecimal totalPrice){
			this.totalPrice = totalPrice;
			return this;
		}
		
		public ShoppingCartBuilder discount(BigDecimal discount){
			this.discount = discount;
			return this;
		}
		
		public ShoppingCartBuilder product(Product product){
			this.product = product;
			return this;
		}
		
		public ShoppingCartBuilder totalQuantity(int totalQuantity){
			this.totalQuantity = totalQuantity;
			return this;
		}
		
		// build 
		public ShoppingCart build(){
			return new ShoppingCart(this);
		}
		
	}
}
