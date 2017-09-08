package com.oguzhanmangir.shoppingcart.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.oguzhanmangir.shoppingcart.domain.ProductToPurchase;
import com.oguzhanmangir.shoppingcart.domain.ShoppingCart;
import com.oguzhanmangir.shoppingcart.domain.entity.Product;
import com.oguzhanmangir.shoppingcart.service.IShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements IShoppingCartService{

	@Override
	public void addProductToShoppingCart(ShoppingCart shoppingCart, Product product) {
		ProductToPurchase productToPurchase = new ProductToPurchase();
		productToPurchase.setProduct(product);
		productToPurchase.setQuantity(1);
		
		Map<Integer, ProductToPurchase> sCart = shoppingCart.getsCart();
		
		if(sCart == null){
			sCart = new HashMap<Integer, ProductToPurchase>();
		}
		
		for(Map.Entry<Integer, ProductToPurchase> entry : sCart.entrySet()){
			if(entry.getKey() == product.getId()){
				productToPurchase.setQuantity(entry.getValue().getQuantity() + 1);
			}
		}
		
		sCart.put(product.getId(), productToPurchase);
	}

	@Override
	public void removeAllInShoppingCart(ShoppingCart shoppingCart) {
		Map<Integer, ProductToPurchase> sCart = shoppingCart.getsCart();
		
		for(Map.Entry<Integer, ProductToPurchase> entry : sCart.entrySet()){
			sCart.remove(entry.getKey());
		}
	}

	@Override
	public void removeProductToShoppingCartByProductId(ShoppingCart shoppingCart, int id) {
		Map<Integer, ProductToPurchase> sCart = shoppingCart.getsCart();
		
		for(Map.Entry<Integer, ProductToPurchase> entry : sCart.entrySet()){
			if(entry.getKey() == id){
				entry.getValue().setQuantity(entry.getValue().getQuantity() - 1);
				if(entry.getValue().getQuantity() == 0){
					sCart.remove(entry.getKey());
				}
			}
		}
	}

	@Override
	public void removeAllProductsInShoppingCartById(ShoppingCart shoppingCart, int id) {
		Map<Integer, ProductToPurchase> sCart = shoppingCart.getsCart();
		
		sCart.remove(id);
	}
	
	@Override
	public BigDecimal calculateTotalPriceInShoppingCart(ShoppingCart shoppingCart) {
		
		Map<Integer, ProductToPurchase> sCart = shoppingCart.getsCart();
		BigDecimal totalPrice = new BigDecimal(0);
		
		for(Map.Entry<Integer, ProductToPurchase> entry : sCart.entrySet()){
			BigDecimal unitPrice = entry.getValue().getProduct().getUnitPrice();
			int quantity = entry.getValue().getQuantity();
			BigDecimal bigQuantity = new BigDecimal(quantity);
			totalPrice = totalPrice.add(unitPrice.multiply(bigQuantity));
		}
		
		return totalPrice;
	}

	@Override
	public int calculateTotalQuantityInShoppingCart(ShoppingCart shoppingCart) {
		
		Map<Integer, ProductToPurchase> sCart = shoppingCart.getsCart();
		int totalQuantity = 0;
		
		for(Map.Entry<Integer, ProductToPurchase> entry : sCart.entrySet()){
			totalQuantity += entry.getValue().getQuantity();
		}
		
		return totalQuantity;	
	}

	@Override
	public List<Product> getAllProductsInShoppingCart(ShoppingCart shoppingCart) {
		
		Map<Integer, ProductToPurchase> sCart = shoppingCart.getsCart();
		List<Product> products = new ArrayList<Product>();
		
		for(Map.Entry<Integer, ProductToPurchase> entry: sCart.entrySet()){
			products.add(entry.getValue().getProduct());
		}
		
		return products;
	}

	@Override
	public Map<Integer, Integer> showProductsQuantity(ShoppingCart shoppingCart) {
		Map<Integer, ProductToPurchase> sCart = shoppingCart.getsCart();
		
		Map<Integer, Integer> productQuantityMap = new TreeMap<Integer, Integer>();
		
		for(Map.Entry<Integer, ProductToPurchase> entry : sCart.entrySet()){
			
			productQuantityMap.put(entry.getKey(), entry.getValue().getQuantity());
		}
		
		
		return productQuantityMap;
	}

}
