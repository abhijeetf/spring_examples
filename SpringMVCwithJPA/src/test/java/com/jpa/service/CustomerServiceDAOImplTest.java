package com.jpa.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jpa.entity.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("jpadao")
public class CustomerServiceDAOImplTest {
	private CustomerService service;
	
	@Autowired
	public void setService(CustomerService service) {
		this.service = service;
	}
	
	@Test
	public void listAll() {
		List<Customer> list = service.lisAll();
		assert list.size() == 3;
	}
	
	@Test
	public void findCustomerbyID() {
		Customer customer = (Customer) service.getByID(6);
		assert customer.getId() == 6 ;
		assert customer.getCity() == "city1";
	}
	
	@Test
	public void createNewCustomer() {
		Customer customer = (Customer) service.create(new Customer("first6", "last6", "customer6.gmail.com", "57777688", 
				"line6", "line7", "city7", "state7", "7777"));
		assert customer.getId() != null ;
		assert customer.getPhoneNumber() == "57777688" ;
	}
	
	@Test
	public void updateCustomer() {
		Customer customer = (Customer) service.update(new Customer(6,"Customer111","Last111","customer1@mail.com","1234567891","line1","line2","city1","state1","123451"));
		assert customer.getFirstName() == "Customer111";
		assert customer.getLastName() == "Last111";
	}
	
	@Test
	public void deleteCustomer() {
		boolean isdeleted = service.delete(7);
		assert isdeleted ;
	}
}
