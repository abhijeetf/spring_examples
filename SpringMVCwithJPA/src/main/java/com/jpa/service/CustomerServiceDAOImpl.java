package com.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.jpa.entity.Customer;
import com.jpa.entity.DomainObject;
import com.jpa.entity.Product;

@Service
@Profile("jpadao")
public class CustomerServiceDAOImpl implements CustomerService {

	private EntityManagerFactory emf;
	
	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public List lisAll() {
		EntityManager entityManager = emf.createEntityManager();
		List<Customer> list = entityManager.createQuery("from Customer", Customer.class).getResultList();
		entityManager.close();
		return list;
	}

	@Override
	public DomainObject getByID(Integer id) {
		EntityManager entityManager = emf.createEntityManager();
		Customer customer = entityManager.find(Customer.class, id);
		entityManager.close();
		return customer;
	}

	@Override
	public DomainObject create(DomainObject entity) {
		return update(entity);
	}

	@Override
	public DomainObject update(DomainObject entity) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		Customer cust = (Customer) entityManager.merge(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return cust;
	}

	@Override
	public boolean delete(Integer id) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.find(Customer.class, id));
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

}
