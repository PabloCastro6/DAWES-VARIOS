package com.pablo.tienda.dtos;

public class CategoriasDTO {
	
	private Integer id;
	private String nombre;
	private String Descripcion;
	private String Activo;
	
	
	public CategoriasDTO(Integer id, String nombre, String descripcion, String activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		Descripcion = descripcion;
		Activo = activo;
	}


	public CategoriasDTO(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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


	public String getDescripcion() {
		return Descripcion;
	}


	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}


	public String getActivo() {
		return Activo;
	}


	public void setActivo(String activo) {
		Activo = activo;
	}
	
	
	

}
