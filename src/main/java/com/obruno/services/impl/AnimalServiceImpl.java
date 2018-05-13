package com.obruno.services.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.obruno.entities.Animal;
import com.obruno.services.AnimalService;

@Stateless
public class AnimalServiceImpl implements AnimalService {
	
	private final Logger logger = Logger.getLogger(
			this.getClass().getName());
		
	@PersistenceContext(name="AdocaoApp")
	private EntityManager em;

	@Override
	public void add(Animal animal) {
		em.persist(animal);
		logger.info("Animal cadastrado: " + animal.toString());
	}
	
	@Override
	public List<Animal> list() {
		return em.createQuery("from Animal", Animal.class).getResultList();
	}
	
	@Override
	public Animal getById(String id) {
		TypedQuery<Animal> query = em.createQuery(
				"from Animal a where a.id = :id", Animal.class);
		
		Animal a = query.setParameter("id", Integer.parseInt(id)).getSingleResult();
		return a;
	}
	
	@Override
	public void remove(Animal animal) {
		em.remove(em.getReference(Animal.class, animal.getId()));
		logger.info("Animal removido!");
	}
	
	@Override
	public void merge(Animal animal) {
		em.merge(animal);		
		logger.info("Animal salvo!");
	}
	
}
