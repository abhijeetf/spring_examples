package com.jpa;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.jpa.entity.Customer;
import com.jpa.entity.Product;
import com.jpa.service.CustomerService;
import com.jpa.service.ProductServcie;

import sun.print.resources.serviceui;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private ProductServcie servcie;
	
	private CustomerService customerservice;
	
	@Autowired
	public void setServcie(ProductServcie servcie) {
		this.servcie = servcie;
	}
	
	@Autowired
	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadProductsInDB();		
		loadCutomersInDB();
	}

	private void loadCutomersInDB() {
		Customer c1 = new Customer("Customer1","Last1","customer1@mail.com","1234567891","line1","line2","city1","state1","123451");
		Customer c2 = new Customer("Customer2","Last2","customer2@mail.com","1234567892","line2","line3","city2","state2","123452");
		Customer c3 = new Customer("Customer3","Last3","customer3@mail.com","1234567893","line3","line4","city3","state3","123453");
		this.customerservice.create(c1);
		this.customerservice.create(c2);
		this.customerservice.create(c3);
	}

	private void loadProductsInDB() {
		Product p1 = new Product("Product 1", new BigDecimal("100.99"), "http://simplespringmvc/images/product1");
		Product p2 = new Product("Product 2", new BigDecimal("200.99"), "http://simplespringmvc/images/product2");
		Product p3 = new Product("Product 3", new BigDecimal("300.99"), "http://simplespringmvc/images/product3");
		Product p4 = new Product("Product 4", new BigDecimal("400.99"), "http://simplespringmvc/images/product4");
		Product p5 = new Product("Product 5", new BigDecimal("500.99"), "http://simplespringmvc/images/product5");
		this.servcie.create(p1);
		this.servcie.create(p2);
		this.servcie.create(p3);
		this.servcie.create(p4);
		this.servcie.create(p5);
	}
	
}
