package com.douglaz.system.model.enums;

public enum Status {
	
	Inactive("inativo", 0),
	Active("Ativo", 1);
	
	private String description;
	private Integer value;

	private Status(String description, Integer value) {
		this.description = description;
		this.value = value;
	}

	public String getDescription() {
		return description;
	}
	
	public Integer getValue() {
		return value;
	}
}
