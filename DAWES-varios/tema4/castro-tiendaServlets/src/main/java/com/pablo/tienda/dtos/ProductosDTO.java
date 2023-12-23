package com.pablo.tienda.dtos;

public class ProductosDTO {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private double precio;
	private Integer CantidadEnStock;
	private Integer idCategoria;
	private Integer idProveedor;
	
	
	public ProductosDTO(Integer id, String nombre, String descripcion, double precio, Integer cantidadEnStock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		CantidadEnStock = cantidadEnStock;
	}


	public ProductosDTO(Integer id, String nombre, String descripcion, double precio, Integer cantidadEnStock,
			Integer idCategoria, Integer idProveedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		CantidadEnStock = cantidadEnStock;
		this.idCategoria = idCategoria;
		this.idProveedor = idProveedor;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public Integer getCantidadEnStock() {
		return CantidadEnStock;
	}


	public void setCantidadEnStock(Integer cantidadEnStock) {
		CantidadEnStock = cantidadEnStock;
	}


	public Integer getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}


	public Integer getIdProveedor() {
		return idProveedor;
	}


	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	
	
}
