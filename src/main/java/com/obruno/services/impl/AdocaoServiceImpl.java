package com.obruno.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.obruno.entities.Animal;
import com.obruno.services.AdocaoService;

@Stateless
public class AdocaoServiceImpl implements AdocaoService {
	
	@PersistenceContext(name="AdocaoApp")
	private EntityManager em;
	
	@Override
	public List<Animal> listDisponiveis() {
		TypedQuery<Animal> query = em.createQuery(
				"from Animal a where a.dataAdocao is null", Animal.class);

		return query.getResultList();
	}
	
	@Override
	public List<Animal> listAdotados() {
		TypedQuery<Animal> query = em.createQuery(
				"from Animal a where a.dataAdocao is not null", Animal.class);

		return query.getResultList();
	}
	
}
