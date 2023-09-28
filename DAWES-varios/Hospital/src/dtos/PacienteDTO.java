package dtos;

public class PacienteDTO {
	private Integer id;
	private String Nombre;
	private String Apellido;
	private String FechaDeNacimiento;
	private String DNI;
	private String Direccion;
	private String Telefono;
	private String Correo;
	private Integer Alergia;
	private String HistoriaMedica;
	
	// constructor, getters y setters 
	
	public PacienteDTO(Integer id, String nombre, String apellido,String FechaDeNacimiento, String dNI, String direccion, String telefono,
			String correo, Integer alergia, String HistoriaMedica) {
		super();
		this.id = id;
		Nombre = nombre;
		Apellido = apellido;
		FechaDeNacimiento = FechaDeNacimiento;
		DNI = dNI;
		Direccion = direccion;
		Telefono = telefono;
		Correo = correo;
		Alergia = alergia;
		HistoriaMedica = HistoriaMedica;
	}

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

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
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
