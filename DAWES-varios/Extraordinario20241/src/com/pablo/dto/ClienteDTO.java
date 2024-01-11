package com.pablo.dto;

import java.sql.Date;

public class ClienteDTO {

	private int idCliente;
	private String nombre;
	private String direccion;
	private String telefono;
	private Integer idFactura;
	private Date fechaFactura;
	private Double montoFactura;

	
	public ClienteDTO(int idCliente, String nombre, String direccion, String telefono) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public ClienteDTO(int idCliente, String nombre, String direccion, String telefono, Integer idFactura,
			Date fechaFactura, Double montoFactura) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.idFactura = idFactura;
		this.fechaFactura = fechaFactura;
		this.montoFactura = montoFactura;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public Double getMontoFactura() {
		return montoFactura;
	}

	public void setMontoFactura(Double montoFactura) {
		this.montoFactura = montoFactura;
	}

	
	@Override
	public String toString() {
		return "ClienteDTO [idCliente=" + idCliente + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
				+ telefono + ", idFactura=" + idFactura + ", fechaFactura=" + fechaFactura + ", montoFactura="
				+ montoFactura + "]";
	}

}
