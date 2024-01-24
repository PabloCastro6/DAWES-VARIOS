package com.pablo.tienda.dtos;

public class PeticionesDTO {
	
	private Integer id;
	private Integer idCliente;
	private Integer idProducto;
	private Integer idEstado;
	private String fecha;
	private Integer cantidad;
	private String nombreCliente;
	private String nombreProducto;
	private String nombreEstado;
	
	
	
	public PeticionesDTO(Integer id, Integer idCliente, Integer idProducto, Integer idEstado, String fecha,
			Integer cantidad, String nombreCliente, String nombreProducto, String nombreEstado) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.idProducto = idProducto;
		this.idEstado = idEstado;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.nombreCliente = nombreCliente;
		this.nombreProducto = nombreProducto;
		this.nombreEstado = nombreEstado;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}



	public Integer getIdProducto() {
		return idProducto;
	}



	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}



	public Integer getIdEstado() {
		return idEstado;
	}



	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
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



	public String getNombreCliente() {
		return nombreCliente;
	}



	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}



	public String getNombreProducto() {
		return nombreProducto;
	}



	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}



	public String getNombreEstado() {
		return nombreEstado;
	}



	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}
	
	
	

}
