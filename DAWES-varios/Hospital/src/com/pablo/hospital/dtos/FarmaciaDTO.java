package com.pablo.hospital.dtos;

public class FarmaciaDTO {
private Integer medicamento;
private String nombre;
private String descripcion;
private Integer cantidadDisponible;
private Float precio;


public FarmaciaDTO(Integer medicamento, String nombre, String descripcion, Integer cantidadDisponible, Float precio) {
	super();
	this.medicamento = medicamento;
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.cantidadDisponible = cantidadDisponible;
	this.precio = precio;
}


public Integer getMedicamento() {
	return medicamento;
}


public void setMedicamento(Integer medicamento) {
	this.medicamento = medicamento;
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
