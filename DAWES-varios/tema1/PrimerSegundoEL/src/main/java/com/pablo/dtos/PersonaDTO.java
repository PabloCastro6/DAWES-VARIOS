package com.pablo.dtos;

import java.io.Serializable;

public class PersonaDTO implements Serializable {
	
	private static final long seraialVersionUID = 1L;
	
	private Integer edad;
	private String nombre;
	
	public PersonaDTO(Integer edad, String nombre) {
		super();
		this.edad = edad;
		this.nombre = nombre;
	}

	public PersonaDTO() {
		super();
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSeraialversionuid() {
		return seraialVersionUID;
	}
	
	

}
