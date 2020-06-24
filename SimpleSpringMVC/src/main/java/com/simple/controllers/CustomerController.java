package com.simple.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simple.entity.Customer;
import com.simple.entity.Product;
import com.simple.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerService service ;

	@Autowired
	public void setService(CustomerService service) {
		this.service = service;
	}
	
	@RequestMapping({"/list","/"})
	public String listCustomers(Model model) {
		model.addAttribute("customers", service.lisAll());
		return "customer/list";
	}
	
	@RequestMapping("/show/{id}")
	public String showCustomer(@PathVariable Integer id, Model model) {
		model.addAttribute("customer", service.getByID(id));
		return "/customer/show";
	}
	
	@RequestMapping("/edit/{id}")
	public String editCutomer(@PathVariable Integer id, Model model) {
		model.addAttribute("customer",service.getByID(id));
		return "/customer/customerform";
	}
	
	@RequestMapping("/new")
	public String addCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "/customer/customerform";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String updateCustomer(Customer customer) {
		
		Customer  savedcustomer = null ;
		if(customer.getId() == null)	
			savedcustomer = (Customer) service.create(customer);
		else	
			savedcustomer = (Customer) service.update(customer);
		
		return "redirect:/customer/show/" + savedcustomer.getId();
	}
	
	
	@RequestMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable Integer id, Model model) {
		service.delete(id);
		return "redirect:/customer/list" ;
	}
	
}
