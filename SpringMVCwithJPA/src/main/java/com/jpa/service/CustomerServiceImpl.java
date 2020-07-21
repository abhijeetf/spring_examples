package com.jpa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.jpa.entity.Customer;
import com.jpa.entity.DomainObject;

@Service
@Profile("map")
public class CustomerServiceImpl extends AbstractService implements CustomerService {
	
	//Map<Integer, DomainObject> map;
	
	public CustomerServiceImpl() {
		super();
	//	map = new HashMap();
	//	loadDomainObjectMap();
	}
	
	protected void loadDomainObjectMap() {
		Customer c1 = new Customer(1,"Customer1","Last1","customer1@mail.com","1234567891","line1","line2","city1","state1","123451");
		Customer c2 = new Customer(2,"Customer2","Last2","customer2@mail.com","1234567892","line2","line3","city2","state2","123452");
		Customer c3 = new Customer(3,"Customer3","Last3","customer3@mail.com","1234567893","line3","line4","city3","state3","123453");
		map.put(c1.getId(), c1);
		map.put(c2.getId(),c2);
		map.put(c3.getId(),c3);
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
		if(entity != null) {
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
