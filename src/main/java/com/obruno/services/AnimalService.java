package com.obruno.services;

import java.util.List;

import com.obruno.entities.Animal;

public interface AnimalService {
	
	public void add(Animal animal);
	
	public List<Animal> list();
	
	public Animal getById(String id);
	
	public void remove(Animal animal);
	
	public void merge(Animal animal);
	
}
