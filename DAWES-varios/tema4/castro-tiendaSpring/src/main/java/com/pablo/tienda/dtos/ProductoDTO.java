package com.pablo.tienda.dtos;

public class ProductoDTO {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private double precio;
	private Integer cantidadEnStock;
	private Integer idCategoria;
	private Integer idProveedor;
	private String categoria;
	private String proveedor;
	
	


	
	public ProductoDTO(Integer id, String nombre, String descripcion, double precio, Integer cantidadEnStock,
			Integer idCategoria, Integer idProveedor, String categoria, String proveedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
		this.idCategoria = idCategoria;
		this.idProveedor = idProveedor;
		this.categoria = categoria;
		this.proveedor = proveedor;
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
		return cantidadEnStock;
	}


	public void setCantidadEnStock(Integer cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
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




	public String getCategoria() {
		return categoria;
	}




	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}




	public String getProveedor() {
		return proveedor;
	}




	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	
	
}
