package com.oguzhanmangir.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oguzhanmangir.shoppingcart.domain.entity.Product;
import com.oguzhanmangir.shoppingcart.service.IProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductCRUDController {

	@Autowired
	private IProductService productService;
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddProduct(@ModelAttribute("newProduct") Product product, Model model){
		
		// return add product page
		return "";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddProduct(@ModelAttribute("newProduct") Product product,
									BindingResult result, Model model){
		
		// applied to validator for add product
		
		if(result.hasErrors()){
			// return add product page again
			return "";
		}
		
		productService.insert(product);
		
		// return home page (redirect)
		return "";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String removeProduct(@RequestParam("id") Integer id,  Model model){
		
		productService.remove(id);
		
		// return home page (redirect)
		return "";
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String showAllProduct(Model model){
		
		model.addAttribute("products", productService.findAll());
		
		// return home page (redirect)
		return "listProduct";
	}
}
