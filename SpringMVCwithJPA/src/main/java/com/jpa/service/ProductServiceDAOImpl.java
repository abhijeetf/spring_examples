package com.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.jpa.entity.DomainObject;
import com.jpa.entity.Product;

@Service
@Profile("jpadao")
public class ProductServiceDAOImpl implements ProductServcie{

	private EntityManagerFactory emf ;
	
	@PersistenceUnit	
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List lisAll() {
		EntityManager em = emf.createEntityManager();
		List<Product> prodList = em.createQuery("from Product", Product.class).getResultList();
		em.close();
		return prodList;
	}

	@Override
	public DomainObject getByID(Integer id) {
		EntityManager em = emf.createEntityManager();
		Product prod =  em.find(Product.class, id);
		em.close();
		return prod ;
	}

	@Override
	public DomainObject create(DomainObject entity) {
		return update(entity);
	}

	@Override
	public DomainObject update(DomainObject entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		DomainObject prod =  em.merge(entity);
		em.getTransaction().commit();
		em.close();
		System.out.println(prod.getId());
		return prod;
	}

	@Override
	public boolean delete(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Product.class, id));
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
}
