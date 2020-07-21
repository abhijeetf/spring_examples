package com.simple.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.mockito.Mockito.*;

import com.simple.entity.Product;
import com.simple.service.ProductServcie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class ProductControllerTest {

	@Mock	
	ProductServcie productServcie ;
	
	@InjectMocks
	ProductController controller ;
	
	private MockMvc mockmvc;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void testListProduct() throws Exception{
		List products = new ArrayList<Product>();
		products.add(new Product(1, "product1", new BigDecimal(23.33), "imageurl1"));
		products.add(new Product(2, "product2", new BigDecimal(33.33), "imageurl2"));
		
		when(productServcie.lisAll()).thenReturn(products);
		
		mockmvc.perform(get("/products")).
									andExpect(status().isOk()).
									andExpect(view().name("product/list")).
									andExpect(model().attribute("products", hasSize(2) )) ;
		
	}
	
	@Test
	public void testGetProduct() throws Exception{
		Product prod = new  Product(1, "product1", new BigDecimal(23.33), "imageurl1");
		Integer id = 1;
		
		when(productServcie.getByID(id)).thenReturn(prod);
		
		mockmvc.perform(get("/product/show/1")).andExpect(status().isOk())
												.andExpect(view().name("product/show"))
												.andExpect(model().attribute("product", instanceOf(Product.class)));
	
	
	}	
	
	@Test
	public void testEditProduct() throws Exception {
		Product prod = new  Product(1, "product1", new BigDecimal(23.33), "imageurl1"); 
		Integer id = 1;
		
		when(productServcie.getByID(id)).thenReturn(prod);
		
		mockmvc.perform(get("/product/edit/1")).andExpect(status().isOk())
										.andExpect(view().name("product/productform"))
										.andExpect(model().attribute("product",(Product) prod));
		
	}
	
	@Test
	public void testCreateProduct() throws Exception {
		verifyZeroInteractions(productServcie);
		
		mockmvc.perform(get("/product/new")).andExpect(status().isOk())
									.andExpect(view().name("product/productform"))
									.andExpect(model().attribute("product", instanceOf(Product.class)));
		
	}
	
	@Test
	public void testUpdateProduct() throws Exception{
		Product prod = new  Product(1, "product1", new BigDecimal("23.33"), "imageurl1");
		
		when(productServcie.create(Matchers.<Product>any())).thenReturn(prod);
		when(productServcie.update(Matchers.<Product>any())).thenReturn(prod);
		
		mockmvc.perform(post("/updateProduct")
		        .param("id", "1")
		        .param("desc","product1")
		        .param("price", "23.33")
		        .param("imageUrl", "imageurl1"))
		                .andExpect(status().is3xxRedirection())
		                .andExpect(view().name("redirect:/product/show/1"))
		                .andExpect(model().attribute("product", instanceOf(Product.class)))
		                .andExpect(model().attribute("product", hasProperty("id", is(prod.getId()))))
		                .andExpect(model().attribute("product", hasProperty("desc", is(prod.getDesc()))))
		                .andExpect(model().attribute("product", hasProperty("price", is(prod.getPrice()))))
		                .andExpect(model().attribute("product", hasProperty("imageUrl", is(prod.getImageUrl()))));

		//verify properties of bound object
        ArgumentCaptor<Product> boundProduct1 = ArgumentCaptor.forClass(Product.class);
        verify(productServcie).update(boundProduct1.capture());
        assertEquals(prod.getId(),boundProduct1.getValue().getId());
        assertEquals(prod.getDesc(), boundProduct1.getValue().getDesc());
        assertEquals(prod.getPrice(), boundProduct1.getValue().getPrice());
        assertEquals(prod.getImageUrl(), boundProduct1.getValue().getImageUrl());

		mockmvc.perform(post("/updateProduct")
		        .param("id", "")
		        .param("desc","product1")
		        .param("price", "23.33")
		        .param("imageUrl", "imageurl1"))
		                .andExpect(status().is3xxRedirection())
		                .andExpect(view().name("redirect:/product/show/1"))
		                .andExpect(model().attribute("product", instanceOf(Product.class)))
		                .andExpect(model().attribute("product", hasProperty("id", isEmptyOrNullString() )))
		                .andExpect(model().attribute("product", hasProperty("desc", is(prod.getDesc()))))
		                .andExpect(model().attribute("product", hasProperty("price", is(prod.getPrice()))))
		                .andExpect(model().attribute("product", hasProperty("imageUrl", is(prod.getImageUrl()))));
		
		//verify properties of bound object
        ArgumentCaptor<Product> boundProduct = ArgumentCaptor.forClass(Product.class);
        verify(productServcie).create(boundProduct.capture());

        assertEquals(prod.getDesc(), boundProduct.getValue().getDesc());
        assertEquals(prod.getPrice(), boundProduct.getValue().getPrice());
        assertEquals(prod.getImageUrl(), boundProduct.getValue().getImageUrl());
	}
	
	@Test
	public void testDeleteProduct() throws Exception{
		Integer id = 1;
		when(productServcie.delete(id)).thenReturn(true);
		
		mockmvc.perform(get("/product/delete/1")).andExpect(status().is3xxRedirection())
												.andExpect(view().name("redirect:/products"));
		verify(productServcie , times(1)).delete(id);
												
	}
	
}



