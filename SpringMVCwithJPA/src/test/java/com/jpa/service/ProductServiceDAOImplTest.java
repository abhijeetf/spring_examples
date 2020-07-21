package com.jpa.service;

import java.util.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("jpadao")
public class ProductServiceDAOImplTest {
	private ProductServcie productService;
	
	@Autowired
	public void setProductServcie(ProductServcie productService) {
		this.productService = productService;
	}
	
	@Test
	public void listAll() {
		List list =	productService.lisAll();
		assert list.size() == 5 ;
	}
	
}
