package com.pablo.dtos;

import java.io.Serializable;

public class Provincia implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descripcion;
	private Integer id;

	

	public Provincia(String descripcion, Integer id) {
		super();
		this.descripcion = descripcion;
		this.id = id;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}

	

	
}