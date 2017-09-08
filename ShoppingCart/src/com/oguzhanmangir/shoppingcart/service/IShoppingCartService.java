package com.oguzhanmangir.shoppingcart.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.oguzhanmangir.shoppingcart.domain.ShoppingCart;
import com.oguzhanmangir.shoppingcart.domain.entity.Product;

public interface IShoppingCartService{
	
	public void addProductToShoppingCart(ShoppingCart shoppingCart, Product product);
	
	public void removeAllInShoppingCart(ShoppingCart shoppingCart);
	
	public void removeProductToShoppingCartByProductId(ShoppingCart shoppingCart, int id);
	
	public void removeAllProductsInShoppingCartById(ShoppingCart shoppingCart, int id);

	public BigDecimal calculateTotalPriceInShoppingCart(ShoppingCart shoppingCart);
	
	public int calculateTotalQuantityInShoppingCart(ShoppingCart shoppingCart);
	
	public List<Product> getAllProductsInShoppingCart(ShoppingCart shoppingCart);
	
	public Map<Integer, Integer> showProductsQuantity(ShoppingCart shoppingCart);
}
