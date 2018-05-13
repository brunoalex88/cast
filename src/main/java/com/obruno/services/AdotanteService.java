package com.obruno.services;

import java.util.List;

import com.obruno.entities.Adotante;
import com.obruno.entities.Animal;

public interface AdotanteService {

	public void add(Adotante adotante);
	
	public List<Adotante> list();
	
	public Adotante getById(Integer id);
	
	public void remove(Adotante adotante);
	
	public void merge(Adotante adotante);
	
	public List<Animal> getAdotados(Integer id);
	
}
