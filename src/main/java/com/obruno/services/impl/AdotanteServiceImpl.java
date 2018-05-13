package com.obruno.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.obruno.entities.Adotante;
import com.obruno.entities.Animal;
import com.obruno.services.AdotanteService;

@Stateless
public class AdotanteServiceImpl implements AdotanteService {

	@PersistenceContext(name = "AdocaoApp")
	private EntityManager em;

	@Override
	public void add(Adotante adotante) {
		em.persist(adotante);
	}

	@Override
	public List<Adotante> list() {
		return em.createQuery("from Adotante", Adotante.class).getResultList();
	}

	@Override
	public Adotante getById(Integer id) {
		TypedQuery<Adotante> query = 
				em.createQuery("from Adotante a where a.id = :id", Adotante.class);

		return query.setParameter("id", id).getSingleResult();
	}

	@Override
	public void remove(Adotante adotante) {
		em.remove(em.getReference(Adotante.class, adotante.getId()));
	}

	@Override
	public void merge(Adotante adotante) {
		em.merge(adotante);
	}
	
	@Override
	public List<Animal> getAdotados(Integer id) {
		TypedQuery<Animal> query = 
				em.createQuery("from Animal a where a.adotante.id = :id", Animal.class);
		return query.setParameter("id", id).getResultList(); 
	}

}
