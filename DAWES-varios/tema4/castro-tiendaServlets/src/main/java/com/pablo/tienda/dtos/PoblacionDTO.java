package com.pablo.tienda.dtos;

public class PoblacionDTO {
	
	private Integer id;
	private String nombre;
	
	
	public PoblacionDTO(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}


	public PoblacionDTO() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
