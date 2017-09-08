package com.oguzhanmangir.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.oguzhanmangir.shoppingcart.domain.entity.Customer;
import com.oguzhanmangir.shoppingcart.service.ICustomerService;

@Controller
@SessionAttributes("customerLogin")
public class CustomerCRUDController {

	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getAddCustomer(@ModelAttribute("newCustomer") Customer customer){
		
		// return register page
		return "register";
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processAddCustomer(@ModelAttribute("newCustomer") Customer customer,
									 BindingResult result, Model model){
		
		// validator for add customer
		
		/*if(result.hasErrors()){
			
			// forward add customer page again
			return "register";
		}*/
		
		// insert customer and address
		customerService.insert(customer);		
		
		// return login page
		return "redirect:/login";
	}
}
