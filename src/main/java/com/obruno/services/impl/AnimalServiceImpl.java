package com.obruno.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.obruno.entities.Animal;
import com.obruno.services.AnimalService;

@Stateless
public class AnimalServiceImpl implements AnimalService {

	@PersistenceContext(name="AdocaoApp")
	private EntityManager em;

	@Override
	public void add(Animal animal) {
		em.persist(animal);
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
	}
	
	@Override
	public void merge(Animal animal) {
		em.merge(animal);		
	}
	
}
