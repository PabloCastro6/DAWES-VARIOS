package com.pablo.tienda.dtos;

public class ClienteDTO {

	private Integer id;
	private String nombre;
	private String correo;
	private Integer idPoblacion;
	private Integer activo;
	private String nombrePoblacion;

	public ClienteDTO(Integer id, String nombre, String correo, Integer idPoblacion, Integer activo,
			String nombrePoblacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.idPoblacion = idPoblacion;
		this.nombrePoblacion = nombrePoblacion;
		this.activo = activo;
	}

	public ClienteDTO() {
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getIdPoblacion() {
		return idPoblacion;
	}

	public void setIdPoblacion(Integer idPoblacion) {
		this.idPoblacion = idPoblacion;
	}

	public String getNombrePoblacion() {
		return nombrePoblacion;
	}

	public void setNombrePoblacion(String nombrePoblacion) {
		this.nombrePoblacion = nombrePoblacion;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

}
