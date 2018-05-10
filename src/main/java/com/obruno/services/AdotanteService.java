package com.obruno.services;

import java.util.List;

import com.obruno.entities.Adotante;

public interface AdotanteService {

	public void add(Adotante adotante);
	
	public List<Adotante> list();
	
	public Adotante getById(String id);
	
	public void remove(Adotante adotante);
	
	public void merge(Adotante adotante);
	
}
