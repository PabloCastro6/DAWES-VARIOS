package dtos;

public class CitasDTO {
	private Integer ID;
	private String pacienteID;
	private String medicoID;
	private String fecha;
	private String hora;
	private String estado;
	
	
	public CitasDTO(Integer iD, String pacienteID, String medicoID, String fecha, String hora, String estado) {
		super();
		ID = iD;
		this.pacienteID = pacienteID;
		this.medicoID = medicoID;
		this.fecha = fecha;
		this.hora = hora;
		this.estado = estado;
		
		
		
	}


	public Integer getID() {
		return ID;
	}


	public void setID(Integer iD) {
		ID = iD;
	}


	public String getPacienteID() {
		return pacienteID;
	}


	public void setPacienteID(String pacienteID) {
		this.pacienteID = pacienteID;
	}


	public String getMedicoID() {
		return medicoID;
	}


	public void setMedicoID(String medicoID) {
		this.medicoID = medicoID;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
}
