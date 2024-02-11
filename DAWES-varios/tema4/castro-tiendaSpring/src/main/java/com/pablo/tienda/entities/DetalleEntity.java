package com.pablo.tienda.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalles_pedido")
public class DetalleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Detalle")
	private Integer detallePedidoID;

	@ManyToOne
	@JoinColumn(name = "ID_Pedido")
	private PedidoEntity pedido;

	@ManyToOne
	@JoinColumn(name = "ID_Producto")
	private ProductoEntity producto;

	@Column(name = "Cantidad")
	private Integer cantidad;

	@Column(name = "PrecioUnitario")
	private Double precioUnitario;

	public DetalleEntity(Integer detallePedidoID, PedidoEntity pedido, ProductoEntity producto, Integer cantidad,
			Double precioUnitario) {
		super();
		this.detallePedidoID = detallePedidoID;
		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	public DetalleEntity() {
		super();
	}

	public Integer getDetallePedidoID() {
		return detallePedidoID;
	}

	public void setDetallePedidoID(Integer detallePedidoID) {
		this.detallePedidoID = detallePedidoID;
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

}
