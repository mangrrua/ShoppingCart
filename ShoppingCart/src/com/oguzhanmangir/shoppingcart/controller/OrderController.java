package com.oguzhanmangir.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.oguzhanmangir.shoppingcart.domain.entity.Customer;
import com.oguzhanmangir.shoppingcart.service.IOrderService;

@Controller
@SessionAttributes(value = {"shoppingCart", "customerLogin"})
@RequestMapping("/my.orders")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping
	public String showOrderPage(@ModelAttribute("customerLogin") Customer customer, Model model){
		
		model.addAttribute("myOrders", orderService.findByCustomerId(customer.getId()));
		
		return "orderList";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String removeOrder(@RequestParam("id") int id, Model model){
		
		orderService.remove(id);
		
		return "redirect:/my.orders";
	}

}
