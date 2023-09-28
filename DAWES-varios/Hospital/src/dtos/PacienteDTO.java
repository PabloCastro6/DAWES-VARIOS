package dtos;

public class PacienteDTO {
	private Integer id;
	private String Nombre;
	private String Apellido;
	private String FechaDeNacimiento;
	private String DNI;
	private String Direccion;
	private String Telefono;
	private String CorreoElectronico;
	private Integer Alergia;
	private String HistoriaMedica;
	
	
	public PacienteDTO(Integer id, String nombre, String apellido, String fechaDeNacimiento, String dNI,
			String direccion, String telefono, String correoElectronico, Integer alergia, String historiaMedica) {
		super();
		this.id = id;
		Nombre = nombre;
		Apellido = apellido;
		FechaDeNacimiento = fechaDeNacimiento;
		DNI = dNI;
		Direccion = direccion;
		Telefono = telefono;
		CorreoElectronico = correoElectronico;
		Alergia = alergia;
		HistoriaMedica = historiaMedica;
	}

	// constructor, getters y setters 
		  

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getApellido() {
		return Apellido;
	}


	public void setApellido(String apellido) {
		Apellido = apellido;
	}


	public String getFechaDeNacimiento() {
		return FechaDeNacimiento;
	}


	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		FechaDeNacimiento = fechaDeNacimiento;
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public String getDireccion() {
		return Direccion;
	}


	public void setDireccion(String direccion) {
		Direccion = direccion;
	}


	public String getTelefono() {
		return Telefono;
	}


	public void setTelefono(String telefono) {
		Telefono = telefono;
	}


	public String getCorreoElectronico() {
		return CorreoElectronico;
	}


	public void setCorreoElectronico(String correoElectronico) {
		CorreoElectronico = correoElectronico;
	}


	public Integer getAlergia() {
		return Alergia;
	}


	public void setAlergia(Integer alergia) {
		Alergia = alergia;
	}


	public String getHistoriaMedica() {
		return HistoriaMedica;
	}


	public void setHistoriaMedica(String historiaMedica) {
		HistoriaMedica = historiaMedica;
	}
	
	
	

	
}
