package dtos;

public class PacienteDTO {
	private Integer iD;
	private String nombre;
	private String apellido;
	private String fechaDeNacimiento;
	private String dNI;
	private String direccion;
	private String telefono;
	private String correoElectronico;
	private Integer alergia;
	private String historiaMedica;
	
	
	public PacienteDTO(Integer id, String nombre, String apellido, String fechaDeNacimiento, String dNI,
			String direccion, String telefono, String correoElectronico, Integer alergia, String historiaMedica) {
		super();
		this.iD = iD;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.dNI = dNI;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.alergia = alergia;
		this.historiaMedica = historiaMedica;
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


	public Integer getAlergia() {
		return alergia;
	}


	public void setAlergia(Integer alergia) {
		this.alergia = alergia;
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
				+ ", correoElectronico=" + correoElectronico + ", alergia=" + alergia + ", historiaMedica="
				+ historiaMedica + "]";
	}

	
		  

	
	

	
}
