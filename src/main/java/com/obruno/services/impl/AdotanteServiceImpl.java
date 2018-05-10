package com.obruno.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.obruno.entities.Adotante;
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
	public Adotante getById(String id) {
		TypedQuery<Adotante> query = em.createQuery("from Adotante a where a.id = :id", Adotante.class);

		Adotante a = query.setParameter("id", Integer.parseInt(id)).getSingleResult();
		return a;
	}

	@Override
	public void remove(Adotante adotante) {
		em.remove(em.getReference(Adotante.class, adotante.getId()));
	}

	@Override
	public void merge(Adotante adotante) {
		em.merge(adotante);
	}

}
