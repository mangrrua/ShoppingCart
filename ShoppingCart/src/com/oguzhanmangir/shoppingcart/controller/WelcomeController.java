package com.oguzhanmangir.shoppingcart.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.oguzhanmangir.shoppingcart.domain.ProductToPurchase;
import com.oguzhanmangir.shoppingcart.domain.ShoppingCart;
import com.oguzhanmangir.shoppingcart.domain.entity.Customer;
import com.oguzhanmangir.shoppingcart.service.IProductService;

@Controller
@SessionAttributes(value = {"shoppingCart", "customerLogin"})
@RequestMapping(value = {"/", "/home"})
public class WelcomeController {

	@Autowired
	private IProductService productService;
	
	@ModelAttribute("shoppingCart")
	public void initializeShoppingCart(Model model){
		
		Map<Integer, ProductToPurchase> sCart = new HashMap<Integer, ProductToPurchase>();
		ShoppingCart shoppingCart = new ShoppingCart.ShoppingCartBuilder(sCart).build();
		
		model.addAttribute("shoppingCart", shoppingCart);	
	}
	
	@ModelAttribute("customerLogin")
	public void initializeCustomerLogin(Model model){
		
		Customer customer = new Customer();
		
		model.addAttribute("customerLogin", customer);	
	}
	
	@RequestMapping
	public String welcome(Model model){
		
		// add product to request with model
		model.addAttribute("products", productService.findAll());
		
		// return home page
		return "home";
	}
	
}
