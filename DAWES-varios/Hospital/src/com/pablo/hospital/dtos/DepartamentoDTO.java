package com.pablo.hospital.dtos;

public class DepartamentoDTO {
	private Integer iD;
	private String nombre;
	private String descripcion;
	private Integer activo;

	public DepartamentoDTO(Integer iD, String nombre, String descripcion, Integer activo) {
		super();
		this.iD = iD;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public DepartamentoDTO(String nombre, String descripcion, Integer activo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public Integer getiD() {
		return iD;
	}

	public void setiD(Integer iD) {
		this.iD = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "DepartamentoDTO [iD=" + iD + ", nombre=" + nombre + ", descripcion=" + descripcion + ", activo="
				+ activo + "]";
	}

}
