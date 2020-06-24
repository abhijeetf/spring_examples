package com.simple.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.simple.entity.DomainObject;
import com.simple.entity.Product;

@Service
public class ProductServiceImpl  extends AbstractService implements ProductServcie {
	
	//Map<Integer, DomainObject> map;
	
	public ProductServiceImpl() {
		super();
	//	map = new HashMap();
	//	loadDomainObjectMap();
	}
	
	protected void loadDomainObjectMap() {
		Product p1 = new Product(1, "Product 1", new BigDecimal("100.99"), "http://simplespringmvc/images/product1");
		Product p2 = new Product(2, "Product 2", new BigDecimal("200.99"), "http://simplespringmvc/images/product2");
		Product p3 = new Product(3, "Product 3", new BigDecimal("300.99"), "http://simplespringmvc/images/product3");
		Product p4 = new Product(4, "Product 4", new BigDecimal("400.99"), "http://simplespringmvc/images/product4");
		Product p5 = new Product(5, "Product 5", new BigDecimal("500.99"), "http://simplespringmvc/images/product5");
		map.put(p1.getId(), p1);
		map.put(p2.getId(), p2);
		map.put(p3.getId(), p3);
		map.put(p4.getId(), p4);
		map.put(p5.getId(), p5);
	}
	
	/*
	private Integer getNextKey() {
		return Collections.max(map.keySet()) + 1 ;
	}

	public List<DomainObject> lisAll() {
		return new ArrayList<DomainObject>(map.values());
	}

	public DomainObject getByID(Integer id) {
		return map.get(id);
	}

	public DomainObject create(DomainObject entity) {
		if(entity != null ) {
			entity.setId(getNextKey());
			map.put(entity.getId(), entity);
		}
		return entity;
	}

	public DomainObject update(DomainObject entity) {
		if(entity != null && entity.getId() != null) {
			map.put(entity.getId(), entity);
		}
		return entity;
	}

	public boolean delete(Integer id) {
		return	map.remove(id) == null ? false : true;
	}
	*/
}
