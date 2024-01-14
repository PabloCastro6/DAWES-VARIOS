package com.pablo.tienda.dtos;

public class ClientesDTO {
	
	private Integer id_cliente;
	private String nombre;
	private String correo;
	private Integer id_poblacion;
	private Integer activo;
	
	
	public ClientesDTO(Integer id_cliente, String nombre, String correo,  Integer id_poblacion, Integer activo) {
		super();
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.correo = correo;
		this.id_poblacion = id_poblacion;
		this.activo = activo;
	}


	public Integer getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCorreoElectronico() {
		return correo;
	}


	public void setCorreoElectronico(String correoElectronico) {
		this.correo = correoElectronico;
	}



	public Integer getId_poblacion() {
		return id_poblacion;
	}


	public void setId_poblacion(Integer id_poblacion) {
		this.id_poblacion = id_poblacion;
	}


	public Integer getActivo() {
		return activo;
	}


	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
	
	
	
	

}
