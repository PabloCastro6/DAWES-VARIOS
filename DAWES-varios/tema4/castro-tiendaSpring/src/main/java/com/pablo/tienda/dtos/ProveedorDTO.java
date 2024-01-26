package com.pablo.tienda.dtos;

public class ProveedorDTO {

	private Integer id;
	private String nombre;
	private String Contacto;
	private String telefono;
	private String correo;
	private String direccion;
	private Integer activo;

	public ProveedorDTO(Integer id, String nombre, String contacto, String telefono, String correo, String direccion,
			Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		Contacto = contacto;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.activo = activo;
	}

	public ProveedorDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId_proveedor(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContacto() {
		return Contacto;
	}

	public void setContacto(String contacto) {
		Contacto = contacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

}
