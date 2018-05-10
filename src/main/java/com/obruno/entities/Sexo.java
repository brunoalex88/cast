package com.obruno.entities;

public enum Sexo {
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	private String value;
	
	Sexo(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
