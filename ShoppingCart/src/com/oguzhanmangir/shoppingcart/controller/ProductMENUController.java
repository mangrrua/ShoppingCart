package com.oguzhanmangir.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oguzhanmangir.shoppingcart.service.IProductService;

@Controller
public class ProductMENUController {

	@Autowired
	private IProductService productService;
	
	@RequestMapping(value = "/category/{categoryName}", method = RequestMethod.GET)
	public String showProductsByCategory(@PathVariable("categoryName") String categoryName, Model model){
		
		model.addAttribute("products", productService.findByCategory(categoryName));
		model.addAttribute("clickCategory", categoryName);
		
		// return list product page
		return "home";
	}
	
	
	@RequestMapping(value = "/brand/{brandName}", method = RequestMethod.GET)
	public String showProductsByBrand(@PathVariable("brandName") String brandName, Model model){
		
		model.addAttribute("products", productService.findByBrand(brandName));
		
		// return list product page
		return "home";
	}
	
	@RequestMapping(value = "/{category}/{brand}")
	public String showProductsByBrandAndCategoru(@PathVariable("category") String category,
												@PathVariable("brand") String brand, Model model){
		
		model.addAttribute("products", productService.findByBrandAndCategory(brand, category));
		
		// return list product page
		return "home";
	}
	
	@RequestMapping(value = "/filter/{productName}", method = RequestMethod.GET)
	public String showProductsByName(@PathVariable("productName") String productName, Model model){
		
		model.addAttribute("products", productService.findByName(productName));
		
		// return list product page
		return "home";
	}
	
	@RequestMapping(value = "/details/{id}")
	public String showDetails(@PathVariable("id") int id, Model model){
		
		model.addAttribute("detailsProduct", productService.find(id));
		
		return "productDetails";
	}
	
}
