package com.oguzhanmangir.shoppingcart.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.oguzhanmangir.shoppingcart.domain.ShoppingCart;
import com.oguzhanmangir.shoppingcart.domain.entity.Product;
import com.oguzhanmangir.shoppingcart.service.IProductService;
import com.oguzhanmangir.shoppingcart.service.IShoppingCartService;

@Controller
@SessionAttributes(value = {"shoppingCart", "customerLogin"})
@RequestMapping(value = "/my.cart")
public class ShoppingCartController {

	@Autowired
	private IShoppingCartService shoppingCartService;
	@Autowired
	private IProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showMyCart(@ModelAttribute("shoppingCart") ShoppingCart shoppingCart,  Model model){
		
		model.addAttribute("productsQuantity", shoppingCartService.showProductsQuantity(shoppingCart));
		model.addAttribute("products", shoppingCartService.getAllProductsInShoppingCart(shoppingCart));
		model.addAttribute("totalPrice", shoppingCartService.calculateTotalPriceInShoppingCart(shoppingCart));
		model.addAttribute("totalQuantity", shoppingCartService.calculateTotalQuantityInShoppingCart(shoppingCart));
				
		// return shopping cart page
		return "shoppingCart";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProductToShoppingCart(@RequestParam("id") int id,
										   @ModelAttribute("shoppingCart") ShoppingCart shoppingCart,
										   Model model){
		
		Product product = productService.find(id);
		
		if(product == null){
			
			return "redirect:/home";
		}
		
		shoppingCartService.addProductToShoppingCart(shoppingCart, product);
		
		// redirect my.cart
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/remove.all", method = RequestMethod.GET)
	public String removeAllInShoppingCart(@ModelAttribute("shoppingCart") ShoppingCart shoppingCart, Model model){
		
		shoppingCartService.removeAllInShoppingCart(shoppingCart);
		
		// redirect my.cart
		return "redirect:/my.cart";
	}
	
	@RequestMapping(value = "/remove.one", method = RequestMethod.GET)
	public String removeProductToShoppingCartByProductId(@ModelAttribute("shoppingCart") ShoppingCart shoppingCart,
														@RequestParam("id") int id){
		
		shoppingCartService.removeProductToShoppingCartByProductId(shoppingCart, id);
		
		// redirect my.cart
		return "redirect:/my.cart";
	}
	
	@RequestMapping(value = "/remove.same.all", method = RequestMethod.GET)
	public String removeAllProductsInShoppingCartById(@ModelAttribute("shoppingCart") ShoppingCart shoppingCart,
														@RequestParam("id") int id){
		
		shoppingCartService.removeAllProductsInShoppingCartById(shoppingCart, id);
		
		// redirect my.cart
		return "redirect:/my.cart";
	}
	
}
