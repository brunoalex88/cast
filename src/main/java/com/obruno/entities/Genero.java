package com.obruno.entities;

public enum Genero {
	
	MAMIFERO("Mam�fero"),
	AVE("Ave"),
	REPTIL("R�ptil"),
	ANFIBIO("Anf�bio"),
	PEIXE("Peixe");
	
	private String value;
	
	Genero(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
