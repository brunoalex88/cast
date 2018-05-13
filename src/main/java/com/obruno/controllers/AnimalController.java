package com.obruno.controllers;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.obruno.entities.Animal;
import com.obruno.entities.Genero;
import com.obruno.entities.SexoAnimal;
import com.obruno.services.AnimalService;

@ManagedBean
@ViewScoped
public class AnimalController {
	
	private final Logger logger = Logger.getLogger(
			this.getClass().getName());
	private Animal animal;
	
	@EJB
	private AnimalService service;
	
	@PostConstruct
	public void init() {
		logger.info("init()");
		if (this.animal == null)
			this.animal = new Animal();
	}
	
	public void addOrEdit(Animal animal) {
		
		if (animal.getId() == null) {
			logger.info("Criando animal");
			service.add(animal);
			addMessage("Animal salvo com sucesso!", FacesMessage.SEVERITY_INFO);						
		} else {
			logger.info("Salvando animal");
			service.merge(animal);
			addMessage("Animal alterado com sucesso!", FacesMessage.SEVERITY_INFO);			
		}
		
		clear();	
	}
	
	public void delete() {
		logger.info("Removendo animal");
		service.remove(getAnimal());
		clear();
	}
	
	public String home() {
		logger.info("home.xhtml");
		setAnimal(null);
		return "home?faces-redirect=true";
	}
	
	public void clear() {
		logger.info("Limpando animal");
		getAnimal().setId(null);
		getAnimal().setDataAdocao(null);
		getAnimal().setDataRecolhimento(null);
		getAnimal().setGenero(null);
		getAnimal().setNome(null);
		getAnimal().setSexo(null);
		getAnimal().setTag(null);;
	}
	
	public void addMessage(String text, FacesMessage.Severity severity) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(severity, text, null);
		facesContext.addMessage(null, facesMessage);		
	}
	
	public List<Animal> list() {
		return service.list();
	}
	
	public Animal getAnimal() {
		return animal;
	}
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public Genero[] getGeneros() {
		return Genero.values();
	}
	
	public SexoAnimal[] getSexos() {
		return SexoAnimal.values();
	}
	
}
