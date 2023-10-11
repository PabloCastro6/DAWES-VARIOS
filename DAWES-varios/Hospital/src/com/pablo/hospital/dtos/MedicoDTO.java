package com.pablo.hospital.dtos;

public class MedicoDTO {
	
	private Integer ID;
	private String nombre;
	private String apellido;
	private String especialidad;
	private String licenciaMedica;
	private String telefono;
	private String correoElectronico;
	
	
	
	



	public MedicoDTO(Integer iD, String nombre, String apellido, String especialidad, String licenciaMedica,
			String telefono, String correoElectronico) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.licenciaMedica = licenciaMedica;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
	}



	public Integer getID() {
		return ID;
	}



	public void setID(Integer iD) {
		ID = iD;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getEspecialidad() {
		return especialidad;
	}



	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}



	public String getLicenciaMedica() {
		return licenciaMedica;
	}



	public void setLicenciaMedica(String licenciaMedica) {
		this.licenciaMedica = licenciaMedica;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getCorreoElectronico() {
		return correoElectronico;
	}



	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}



	@Override
	public String toString() {
		return "MedicosDTO [ID=" + ID + ", nombre=" + nombre + ", apellido=" + apellido + ", especialidad="
				+ especialidad + ", licenciaMedica=" + licenciaMedica + ", telefono=" + telefono
				+ ", correoElectronico=" + correoElectronico + "]";
	}
	
	
	
	
	

	

}
