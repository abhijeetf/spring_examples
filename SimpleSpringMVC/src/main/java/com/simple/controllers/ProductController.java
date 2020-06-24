package com.simple.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simple.entity.Product;
import com.simple.service.ProductServcie;

@Controller
public class ProductController {
	
	private ProductServcie service ;
	
	@Autowired
	public void setService(ProductServcie service) {
		this.service = service;
	}
		
	@RequestMapping("/products")
	public String listProducts(Model model) {
		model.addAttribute("products", service.lisAll());
		return "product/list"; 
	}
	
	@RequestMapping("/product/show/{id}")
	public String getProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("product", service.getByID(id));
		return "product/show";
	}
	
	@RequestMapping("/product/edit/{id}")
	public String editProduct(@PathVariable Integer id, Model model){
		model.addAttribute("product", service.getByID(id));		
		return "product/productform"; 
	}
	
	@RequestMapping("/product/new")
	public String createProduct(Model model) {
		model.addAttribute("product", new Product());
		return "product/productform";
	}
	
	@RequestMapping(value="/updateProduct", method = RequestMethod.POST)
	public String updateProduct(Product product) {
		Product  savedProduct = null ;
		if(product.getId() == null)	
			  	savedProduct = (Product) service.create(product);
		else	
				savedProduct = (Product) service.update(product);
		
		return "redirect:/product/show/" + savedProduct.getId();
	}
	
	@RequestMapping("/product/delete/{id}")
	public String deleteProduct(@PathVariable Integer id, Model model){
		service.delete(id);
		return "redirect:/products";
	}
	
}
