package com.pablo.tienda.entities;

import jakarta.persistence.Table;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "poblacion")
public class PoblacionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Nombre", nullable = false)
	private String nombre;

	@OneToMany(mappedBy = "poblacion")
	private Set<ClientesEntity> clientes;

	public PoblacionEntity(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public PoblacionEntity() {
		super();
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

	@Override
	public String toString() {
		return "PoblacionEntity [id=" + id + ", nombre=" + nombre + "]";
	}

}
