package com.pablo.tienda.entities;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "clientes")
public class ClientesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Cliente")
	private Integer id;

	@Column(name = "Nombre", nullable = false)
	private String nombre;

	@Column(name = "CorreoElectronico", nullable = false, unique = true)
	private String correoElectronico;

	@Column(name = "password")
	private String contraseña;

	@Column(name = "FechaRegistro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;

	@ManyToOne
	@JoinColumn(name = "ID_Poblacion")
	@JsonBackReference
	private PoblacionEntity poblacion;

	@Column(name = "activo")
	private Integer activo;

//	private PoblacionEntity poblacion;

	// ...otros campos...

	@OneToMany(mappedBy = "cliente")
	private Set<PedidoEntity> pedidos;

	@OneToMany(mappedBy = "cliente")
	private Set<PeticionEntity> peticiones;

// Getters y setters...

	public ClientesEntity(String nombre, String correoElectronico, PoblacionEntity poblacion, Integer activo) {
		super();
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.activo = activo;
		this.poblacion = poblacion;
	}

	public ClientesEntity(Integer id, String nombre, String correoElectronico, PoblacionEntity poblacion,
			Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.activo = activo;
		this.poblacion = poblacion;
	}

	public ClientesEntity() {
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

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getPassword() {
		return contraseña;
	}

	public void setPassword(String password) {
		this.contraseña = password;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

//	public Integer getIdPoblacion() {
//		return idPoblacion;
//	}
//
//	public void setIdPoblacion(Integer idPoblacion) {
//		this.idPoblacion = idPoblacion;
//	}

//	public String getNombrePoblacion() {
//		return nombrePoblacion;
//	}
//
//	public void setNombrePoblacion(String nombrePoblacion) {
//		this.nombrePoblacion = nombrePoblacion;
//	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public PoblacionEntity getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(PoblacionEntity poblacion) {
		this.poblacion = poblacion;
	}

}