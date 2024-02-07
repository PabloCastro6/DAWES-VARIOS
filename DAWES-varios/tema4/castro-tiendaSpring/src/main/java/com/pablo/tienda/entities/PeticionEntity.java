package com.pablo.tienda.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "peticiones")
public class PeticionEntity {

	@Id
	@Column(name = "ID_Peticiones")
	private Integer peticionID;

	@ManyToOne
	@JoinColumn(name = "ID_Cliente")
	private ClientesEntity cliente;

	@ManyToOne
	@JoinColumn(name = "ID_Producto")
	private ProductoEntity producto;

	@Column(name = "FechaAñadido")
	@Temporal(TemporalType.TIMESTAMP)
	private String fecha;

	@Column(name = "cantidad")
	private Integer cantidad;

	@ManyToOne
	@JoinColumn(name = "Estado")
	private EstadoPedidoEntity estado;

	public PeticionEntity(Integer peticionID, ClientesEntity cliente, ProductoEntity producto, String fecha,
			Integer cantidad, EstadoPedidoEntity estado) {
		super();
		this.peticionID = peticionID;
		this.cliente = cliente;
		this.producto = producto;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.estado = estado;
	}

	public PeticionEntity() {
		super();
	}

	public PeticionEntity(ClientesEntity cliente, ProductoEntity producto, String fecha, Integer cantidad,
			EstadoPedidoEntity estado) {
		super();
		this.cliente = cliente;
		this.producto = producto;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.estado = estado;
	}

	public Integer getPeticionID() {
		return peticionID;
	}

	public void setPeticionID(Integer peticionID) {
		this.peticionID = peticionID;
	}

	public ClientesEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClientesEntity cliente) {
		this.cliente = cliente;
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
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

	public EstadoPedidoEntity getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedidoEntity estado) {
		this.estado = estado;
	}

}