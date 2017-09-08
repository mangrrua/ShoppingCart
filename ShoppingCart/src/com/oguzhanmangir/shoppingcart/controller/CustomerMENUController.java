package com.oguzhanmangir.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.oguzhanmangir.shoppingcart.domain.entity.Customer;
import com.oguzhanmangir.shoppingcart.service.ICustomerService;

@Controller
@SessionAttributes(value = {"isLoginCase", "customerLogin"})
public class CustomerMENUController {

	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getShowLogin(@ModelAttribute("customerLogin") Customer customer, Model model){
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processShowLogin(@ModelAttribute("customerLogin") Customer customer, Model model){
		
		Customer findCustomer = customerService.login(customer.getUserName(), customer.getPassword());
		
		if(findCustomer == null){
			
			model.addAttribute("failedLogin", "Username or password is not correct !");
			model.addAttribute("isLoginCase", "failed");
			return "login";
		}
		
		model.addAttribute("customerLogin", findCustomer);
		model.addAttribute("isLoginCase", "correct");
		
		// return home page (redirect)
		return "redirect:/home";
	}
	// show profile
	@RequestMapping(value = "/{profile}", method = RequestMethod.GET)
	public String showProfile(@ModelAttribute("customerLogin") Customer customer, Model model){
		
		model.addAttribute("profile", customer);
		
		// return profile page
		return "";
	}	
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(SessionStatus status){
		
		status.setComplete();
		return "redirect:/home";
	}
}
