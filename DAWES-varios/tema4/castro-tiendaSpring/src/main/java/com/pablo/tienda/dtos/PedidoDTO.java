package com.pablo.tienda.dtos;

public class PedidoDTO {
	
	private Integer idPedido;
	private Integer idCliente;
	private String nombreCliente;
	private String fecha;
	private Integer idEstado;
	private String nombreProducto;
	private String nombre;
	private Integer idProducto;
	private Integer cantidad ;
	private Double precio;
	
	
	
	public PedidoDTO(Integer idPedido, Integer idCliente, String nombreCliente, String fecha, Integer idEstado,
			String nombreProducto, String nombre, Integer idProducto, Integer cantidad, Double precio) {
		super();
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.fecha = fecha;
		this.idEstado = idEstado;
		this.nombreProducto = nombreProducto;
		this.nombre = nombre;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precio = precio;
	}



	public PedidoDTO() {
		super();
	}



	public Integer getIdPedido() {
		return idPedido;
	}



	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
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



	public String getNombreProducto() {
		return nombreProducto;
	}



	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Integer getIdProducto() {
		return idProducto;
	}



	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
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
