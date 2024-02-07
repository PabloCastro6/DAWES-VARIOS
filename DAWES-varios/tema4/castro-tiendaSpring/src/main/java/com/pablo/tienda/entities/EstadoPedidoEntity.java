package com.pablo.tienda.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "estadospedidos")
public class EstadoPedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EstadoID")
	private Integer id;

	@Column(name = "NombreEstado", nullable = false)
	private String nombre;

	@OneToMany(mappedBy = "estado")
	private Set<PedidoEntity> pedido;

	@OneToMany(mappedBy = "estado")
	private Set<PeticionEntity> peticion;

	public EstadoPedidoEntity(Integer id, String nombre, Set<PedidoEntity> pedido, Set<PeticionEntity> peticion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pedido = pedido;
		this.peticion = peticion;
	}

	public EstadoPedidoEntity() {
		super();
	}

	public EstadoPedidoEntity(String nombre, Set<PedidoEntity> pedido, Set<PeticionEntity> peticion) {
		super();
		this.nombre = nombre;
		this.pedido = pedido;
		this.peticion = peticion;
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

	public Set<PedidoEntity> getPedido() {
		return pedido;
	}

	public void setPedido(Set<PedidoEntity> pedido) {
		this.pedido = pedido;
	}

	public Set<PeticionEntity> getPeticion() {
		return peticion;
	}

	public void setPeticion(Set<PeticionEntity> peticion) {
		this.peticion = peticion;
	}
}
