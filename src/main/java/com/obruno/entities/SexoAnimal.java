package com.obruno.entities;

public enum SexoAnimal {
	MACHO("Macho"),
	FEMEA("F�mea");
	
	private String value;
	
	SexoAnimal(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}