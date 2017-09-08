package com.oguzhanmangir.shoppingcart.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.oguzhanmangir.shoppingcart.domain.CreditCard;
import com.oguzhanmangir.shoppingcart.domain.ShoppingCart;
import com.oguzhanmangir.shoppingcart.domain.entity.Customer;
import com.oguzhanmangir.shoppingcart.domain.entity.Orders;
import com.oguzhanmangir.shoppingcart.service.IOrderService;

@Controller
@SessionAttributes(value = {"shoppingCart", "customerLogin"})
public class PaymentController {
	
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String showPaymentPage(@ModelAttribute("paymentData") CreditCard creditCard){
		
		return "payment";
	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String processPaymentForm(@ModelAttribute("shoppingCart") ShoppingCart shoppingCart ,
									@ModelAttribute("customerLogin") Customer customer,
									@ModelAttribute("paymentData") CreditCard creditCard, Model model){
		
		Date creationTime = new Date();
		
		Orders order = new Orders();
		//order.setCreationTime(creationTime);
		order.setCustomer(customer);
		order.setDescription("default desc. for this order");
		order.setTotalPrice(shoppingCart.getTotalPrice());
		order.setTotalQuantity(shoppingCart.getTotalQuantity());
		
		orderService.insert(order);
		
		return "redirect:/my.orders";
	}

}
