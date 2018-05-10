package com.obruno.entities;

public enum SexoAnimal {
	MACHO("Macho"),
	FEMEA("Fêmea");
	
	private String value;
	
	SexoAnimal(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}