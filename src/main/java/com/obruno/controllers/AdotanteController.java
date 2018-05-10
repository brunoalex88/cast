package com.obruno.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.obruno.entities.Adotante;
import com.obruno.entities.Sexo;
import com.obruno.services.AdotanteService;

@ManagedBean
@RequestScoped
public class AdotanteController {

	private Adotante adotante;
	
	@EJB
	private AdotanteService service;
	
	@PostConstruct
	public void init() {
		if (this.adotante == null)
			this.adotante = new Adotante();
	}
	
	public void addOrEdit(Adotante adotante) {
		
		if (adotante.getId() == null) {
			service.add(adotante);
			addMessage("Adotante salvo com sucesso!", FacesMessage.SEVERITY_INFO);						
		} else {
			service.merge(adotante);
			addMessage("Adotante alterado com sucesso!", FacesMessage.SEVERITY_INFO);			
		}
		
		clear();	
	}
	
	public void delete() {
		service.remove(getAdotante());
		clear();
	}
	
	public Sexo[] getSexos() {
		return Sexo.values();
	}
	
	public List<Adotante> list() {
		return service.list();
	}
	
	public void addMessage(String text, FacesMessage.Severity severity) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(severity, text, null);
		facesContext.addMessage(null, facesMessage);		
	}
	
	public void clear() {
		getAdotante().setId(null);
		getAdotante().setAreaLocal(null);
		getAdotante().setBairro(null);
		getAdotante().setCpf(null);
		getAdotante().setDataNascimento(null);
		getAdotante().setEndereco(null);
		getAdotante().setNome(null);
		getAdotante().setNumero(null);
		getAdotante().setProfissao(null);
		getAdotante().setQuantidadeDeAnimais(null);
		getAdotante().setQuantMoradores(null);
		getAdotante().setRg(null);
		getAdotante().setSexo(null);
	}		
	
	public Adotante getAdotante() {
		return adotante;
	}
	
	public void setAdotante(Adotante adotante) {
		this.adotante = adotante;
	}
	
}
