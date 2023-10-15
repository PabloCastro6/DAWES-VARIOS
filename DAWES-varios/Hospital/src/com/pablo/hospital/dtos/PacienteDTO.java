package com.pablo.hospital.dtos;

public class PacienteDTO {
	private Integer iD;
	private String nombre;
	private String apellido;
	private String fechaDeNacimiento;
	private String dNI;
	private String direccion;
	private String telefono;
	private String correoElectronico;
	private AlergiaDTO alergiaDTO;
	private String historiaMedica;

	public PacienteDTO(Integer iD, String nombre, String apellido, String fechaDeNacimiento, String dNI,
			String direccion, String telefono, String correoElectronico, String descripcionAlergia,
			String historiaMedica) {
		super();
		this.iD = iD;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.dNI = dNI;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.alergiaDTO = new AlergiaDTO(descripcionAlergia);
		this.historiaMedica = historiaMedica;
	}

	public PacienteDTO(String nombre, String apellido, String fechaDeNacimiento, String dNI, String direccion,
			String telefono, String correoElectronico, String descripcionAlergia, String historiaMedica) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.dNI = dNI;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.alergiaDTO = new AlergiaDTO(descripcionAlergia);
		this.historiaMedica = historiaMedica;
	}

	public PacienteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	// constructor, getters y setters
	public Integer getiD() {
		return iD;
	}

	public void setiD(Integer iD) {
		this.iD = iD;
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

	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getdNI() {
		return dNI;
	}

	public void setdNI(String dNI) {
		this.dNI = dNI;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public AlergiaDTO getAlergiaDTO() {
		return alergiaDTO;
	}

	public void setAlergiaDTO(AlergiaDTO alergiaDTO) {
		this.alergiaDTO = alergiaDTO;
	}

	public String getHistoriaMedica() {
		return historiaMedica;
	}

	public void setHistoriaMedica(String historiaMedica) {
		this.historiaMedica = historiaMedica;
	}

	@Override
	public String toString() {
		return "PacienteDTO [iD=" + iD + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaDeNacimiento="
				+ fechaDeNacimiento + ", dNI=" + dNI + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", correoElectronico=" + correoElectronico + ", alergiaDTO=" + alergiaDTO + ", historiaMedica="
				+ historiaMedica + "]";
	}

}
