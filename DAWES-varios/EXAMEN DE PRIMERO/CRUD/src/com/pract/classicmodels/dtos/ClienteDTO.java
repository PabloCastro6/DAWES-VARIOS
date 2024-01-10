package com.pract.classicmodels.dtos;

public class ClienteDTO {

	private String nombre;
	private String telefono;
	private String apellido;
	private String direccion;


	public ClienteDTO(String nombre, String telefono, String apellido, String direccion) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.apellido = apellido;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
