package com.simple.service;

import java.util.List;

import com.simple.entity.DomainObject;

public interface CRUDService<T> {
	public List<DomainObject> lisAll();
	
	public DomainObject getByID(Integer id);
	
	public DomainObject create(DomainObject entity);
	
	public DomainObject update(DomainObject entity);
	
	public boolean delete(Integer id);

}
