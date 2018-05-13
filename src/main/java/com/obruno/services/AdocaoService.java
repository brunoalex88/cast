package com.obruno.services;

import java.util.List;

import com.obruno.entities.Animal;

public interface AdocaoService {
	
	public List<Animal> listAdotados();
	public List<Animal> listDisponiveis();
	
}
