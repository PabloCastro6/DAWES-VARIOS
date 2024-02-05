package com.pablo.tienda.entities;

import java.util.Date;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Pedido")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "ID_Cliente")
	private ClientesEntity cliente;

	@Column(name = "FechaPedido")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;

	@ManyToOne
	@JoinColumn(name = "EstadoID")
	private EstadoPedidoEntity estado;

	@OneToMany(mappedBy = "pedido")
	private Set<DetalleEntity> detallesPedido;

	public PedidoEntity(Integer id, ClientesEntity cliente, Date fechaRegistro, EstadoPedidoEntity estado,
			Set<DetalleEntity> detallesPedido) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
		this.detallesPedido = detallesPedido;
	}

	public PedidoEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClientesEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClientesEntity cliente) {
		this.cliente = cliente;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public EstadoPedidoEntity getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedidoEntity estado) {
		this.estado = estado;
	}

	public Set<DetalleEntity> getDetallesPedido() {
		return detallesPedido;
	}

	public void setDetallesPedido(Set<DetalleEntity> detallesPedido) {
		this.detallesPedido = detallesPedido;
	}

}
