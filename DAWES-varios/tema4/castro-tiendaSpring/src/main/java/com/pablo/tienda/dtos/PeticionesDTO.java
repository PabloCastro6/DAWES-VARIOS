package com.pablo.tienda.dtos;

public class PeticionesDTO {
	
	private Integer idPeticiones;
	private Integer idCliente;
	private String nombreCliente;
	private Integer idProducto;
	private String nombreProducto;
	private String fecha;
	private Integer cantidad;
	private Integer estado;
	private String nombreEstado;

	public PeticionesDTO(Integer idPeticiones, Integer idCliente, Integer idProducto, String fechaAnhadido,
			Integer cantidad, Integer estado, String nombreCliente, String nombreProducto) {
		super();
		this.idPeticiones = idPeticiones;
		this.idCliente = idCliente;
		this.idProducto = idProducto;
		this.fecha = fechaAnhadido;
		this.cantidad = cantidad;
		this.estado = estado;
		this.nombreCliente = nombreCliente;
		this.nombreProducto = nombreProducto;
	}

	public PeticionesDTO(Integer idPeticiones, Integer idCliente, String nombreCliente, Integer idProducto,
			String nombreProducto, String fecha, Integer cantidad, Integer estado, String nombreEstado) {
		super();
		this.idPeticiones = idPeticiones;
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.estado = estado;
		this.nombreEstado = nombreEstado;
	}

	public Integer getIdPeticiones() {
		return idPeticiones;
	}

	public void setIdPeticiones(Integer idPeticiones) {
		this.idPeticiones = idPeticiones;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

}

