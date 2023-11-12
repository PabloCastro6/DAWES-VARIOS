package com.pablo.hospital.dtos;

public class FarmaciaDTO {
	private String ID;
	private String nombre;
	private String descripcion;
	private Integer cantidadDisponible;
	private Float precio;

	public FarmaciaDTO(String ID, String nombre, String descripcion, Integer cantidadDisponible, Float precio) {
		super();
		this.ID = ID;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidadDisponible = cantidadDisponible;
		this.precio = precio;
	}

	public FarmaciaDTO(String nombre, String descripcion, Integer cantidadDisponible, Float precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidadDisponible = cantidadDisponible;
		this.precio = precio;
	}

	public String getMedicamento() {
		return ID;
	}

	public void setMedicamento(String medicamento) {
		this.ID = medicamento;
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

	public Integer getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

}
