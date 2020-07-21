package com.jpa.service;

import java.util.List;

import com.jpa.entity.DomainObject;

public interface CRUDService<T> {
	public List<DomainObject> lisAll();
	
	public DomainObject getByID(Integer id);
	
	public DomainObject create(DomainObject entity);
	
	public DomainObject update(DomainObject entity);
	
	public boolean delete(Integer id);

}
