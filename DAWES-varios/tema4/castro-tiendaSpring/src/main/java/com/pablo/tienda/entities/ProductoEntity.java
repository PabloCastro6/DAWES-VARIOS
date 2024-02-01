package com.pablo.tienda.entities;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class ProductoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Producto")
	private int id;

	@Column(name = "Nombre", nullable = false)
	private String nombre;

	@Column(name = "Descripcion")
	private String descripcion;

	@Column(name = "Precio")
	private BigDecimal precio;

	@Column(name = "CantidadEnStock")
	private Integer cantidadEnStock;

	@ManyToOne
	@JoinColumn(name = "ID_Categoria")
	private CategoriasEntity categoriaEntity;

	@ManyToOne
	@JoinColumn(name = "ID_Proveedor")
	private ProveedorEntity proveedorEntity;

//  @OneToMany(mappedBy = "producto")
//  private Set<Peticion> peticiones;

//  @OneToMany(mappedBy = "producto")
//  private Set<DetallePedido> detallePedidos;

	public ProductoEntity(String nombre, String descripcion, BigDecimal precio, Integer cantidadEnStock,
			CategoriasEntity categoria, ProveedorEntity proveedorEntity) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
		this.categoriaEntity = categoria;
		this.proveedorEntity = proveedorEntity;
	}

	public ProductoEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getCantidadEnStock() {
		return cantidadEnStock;
	}

	public void setCantidadEnStock(Integer cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}

	public CategoriasEntity getCategoria() {
		return categoriaEntity;
	}

	public void setCategoria(CategoriasEntity categoria) {
		this.categoriaEntity = categoria;
	}

	public ProveedorEntity getProveedorEntity() {
		return proveedorEntity;
	}

}
