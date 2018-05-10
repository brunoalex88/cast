package com.obruno.entities;

public enum Genero {
	
	MAMIFERO("Mamífero"),
	AVE("Ave"),
	REPTIL("Réptil"),
	ANFIBIO("Anfíbio"),
	PEIXE("Peixe");
	
	private String value;
	
	Genero(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
