package com.pablo.hospital.dtos;

public class AlergiaDTO {
	private String id;
	private String descripcion;

	// constructor, getters y setters

	public AlergiaDTO(String id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;

	}

	public AlergiaDTO(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public AlergiaDTO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
