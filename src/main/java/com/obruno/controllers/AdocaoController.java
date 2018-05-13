package com.obruno.controllers;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.obruno.entities.Adotante;
import com.obruno.entities.Animal;
import com.obruno.services.AdocaoService;
import com.obruno.services.AdotanteService;
import com.obruno.services.AnimalService;

@ManagedBean
@ViewScoped
public class AdocaoController {

	private Animal animal;
	private Adotante adotante;

	@EJB
	private AdocaoService service;
	
	@EJB
	private AdotanteService adotanteService;
	
	@EJB
	private AnimalService animalService;
	
	public void adotar() {

		if (this.adotante.getQuantMoradores() > 4 &&
				this.adotante.getAreaLocal() <= 50) {

        	addMessage("Residência com até 50 m² podem haver até 3 moradores", FacesMessage.SEVERITY_ERROR);
        	return;
		}
		
		this.adotante.setQuantidadeDeAnimais(
				this.adotante.getQuantidadeDeAnimais() + 1);
		this.animal.setAdotante(adotante);
		this.animal.setDataAdocao(new Date());
		adotanteService.merge(adotante);
		animalService.merge(animal);
		
		addMessage("Parabéns! O animal foi adotado com sucesso", FacesMessage.SEVERITY_INFO);
	}
	
	public void retornar() {
		setAdotante(adotanteService.getById(
				getAnimal().getAdotante().getId()));
		getAdotante().setQuantidadeDeAnimais(
				getAdotante().getQuantidadeDeAnimais() - 1);
		
		getAnimal().setDataAdocao(null);
		getAnimal().setAdotante(null);
		getAnimal().setDataRecolhimento(new Date());
		
		adotanteService.merge(getAdotante());
		animalService.merge(getAnimal());
		
		addMessage("Animal foi retornado devido a não adaptação", FacesMessage.SEVERITY_INFO);		
	}
	
	public List<Animal> listAdotados() {
		return service.listAdotados();
	}

	public List<Animal> listDisponiveis() {
		return service.listDisponiveis();
	}
	
	public String diasRecolhimento(Date dataRecolhimento) {
	    Long diff = new Date().getTime() - dataRecolhimento.getTime();
	    Long days = diff / (1000*60*60*24);
	    return String.valueOf(days);
	}

	public String diasAdotado(Date dataAdocao) {
	    Long diff = new Date().getTime() - dataAdocao.getTime();
	    Long days = diff / (1000 * 60 * 60 * 24);
	    return String.valueOf(days);
	}
	
	public String diasAteAdocao(Date dataRecolhimento, Date dataAdocao) {
	    Long diff = dataAdocao.getTime() - dataRecolhimento.getTime();
	    Long days = diff / (1000 * 60 * 60 * 24);
	    return String.valueOf(days);		
	}
	
	public void addMessage(String text, FacesMessage.Severity severity) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(severity, text, null);
		facesContext.addMessage(null, facesMessage);		
	}	
	
	public void setAdotante(Adotante adotante) {
		this.adotante = adotante;
	}
	
	public Adotante getAdotante() {
		return adotante;
	}
	
	public Animal getAnimal() {
		return animal;
	}
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
}
