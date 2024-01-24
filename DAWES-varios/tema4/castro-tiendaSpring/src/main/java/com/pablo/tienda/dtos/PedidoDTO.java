package com.pablo.tienda.dtos;

public class PedidoDTO {
	public Integer id;
	public Integer idCliente;
	public String nombreCliente;
	public String fecha;
	public Integer idEstado;
	public String nombreEstado;
	public Integer idProducto;
	public String nombreProducto;
	public Integer cantidad;
	public Double precio;
	

	public PedidoDTO(Integer id, Integer idCliente, String fecha, Integer idEstado, String nombreCliente,
			String nombreEstado,Integer idProducto,String nombreProducto,Integer cantidad,Double precio) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.fecha = fecha;
		this.idEstado = idEstado;
		this.nombreCliente = nombreCliente;
		this.nombreEstado = nombreEstado;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.precio = precio;
		
	}
	
	
	public PedidoDTO( Integer idCliente, Integer idProducto, Integer cantidad, Double precio,Integer id) {
		super();
		this.idCliente = idCliente;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.id = id;
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


	public String getNombreCliente() {
		return nombreCliente;
	}


	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public Integer getIdEstado() {
		return idEstado;
	}


	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}


	public String getNombreEstado() {
		return nombreEstado;
	}


	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
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


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}



}
	
	
	
	
	


