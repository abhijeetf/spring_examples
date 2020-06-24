package com.simple.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.simple.entity.DomainObject;

public abstract class AbstractService {
	
	protected Map<Integer, DomainObject> map ;
	
	public AbstractService() {
		map = new HashMap<Integer, DomainObject>();
		loadDomainObjectMap();
	}

	protected abstract void loadDomainObjectMap();
	
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
}
