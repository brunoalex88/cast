package com.obruno.controllers;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.obruno.entities.Adotante;
import com.obruno.entities.Animal;
import com.obruno.entities.Sexo;
import com.obruno.services.AdotanteService;

@ManagedBean
@ViewScoped
public class AdotanteController {
	
	private final Logger logger = Logger.getLogger(
			this.getClass().getName());
	private Adotante adotante;
	
	@EJB
	private AdotanteService service;
	
	@PostConstruct
	public void init() {
		logger.info("init()");
		if (this.adotante == null)
			this.adotante = new Adotante();
	}
	
	public List<Animal> adotados() {
		return service.getAdotados(1);
	}
	
	public void addOrEdit() {
		
		if (getAdotante().getId() == null) {
			logger.info("Criando adotante");
			service.add(getAdotante());
			addMessage("Adotante salvo com sucesso!", FacesMessage.SEVERITY_INFO);						
		} else {
			logger.info("Salvando adotante");
			service.merge(getAdotante());
			addMessage("Adotante alterado com sucesso!", FacesMessage.SEVERITY_INFO);			
		}
		
		clear();	
	}
	
	public void delete() {
		logger.info("Removendo adotante");
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
		logger.info("Limpando adotante");
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
		getAdotante().setTelefone(null);
	}		
	
	public Adotante getAdotante() {
		return adotante;
	}
	
	public void setAdotante(Adotante adotante) {
		this.adotante = adotante;
	}
	
}
