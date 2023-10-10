package dtos;

public class HistorialMedicoDTO {
	
	private Integer ID;
	private Integer PacienteID;
	private Integer MedicoID;
	private String Fecha;
	private String Diagnostico;
	private String Tratamiento;
	
	
	
	public HistorialMedicoDTO(Integer iD, Integer pacienteID, Integer medicoID, String fecha, String diagnostico,
			String tratamiento) {
		super();
		ID = iD;
		PacienteID = pacienteID;
		MedicoID = medicoID;
		Fecha = fecha;
		Diagnostico = diagnostico;
		Tratamiento = tratamiento;
	}



	public HistorialMedicoDTO() {
		super();
	}



	public Integer getID() {
		return ID;
	}



	public void setID(Integer iD) {
		ID = iD;
	}



	public Integer getPacienteID() {
		return PacienteID;
	}



	public void setPacienteID(Integer pacienteID) {
		PacienteID = pacienteID;
	}



	public Integer getMedicoID() {
		return MedicoID;
	}



	public void setMedicoID(Integer medicoID) {
		MedicoID = medicoID;
	}



	public String getFecha() {
		return Fecha;
	}



	public void setFecha(String fecha) {
		Fecha = fecha;
	}



	public String getDiagnostico() {
		return Diagnostico;
	}



	public void setDiagnostico(String diagnostico) {
		Diagnostico = diagnostico;
	}



	public String getTratamiento() {
		return Tratamiento;
	}



	public void setTratamiento(String tratamiento) {
		Tratamiento = tratamiento;
	}



	@Override
	public String toString() {
		return "HistorialMedicoDTO [ID=" + ID + ", PacienteID=" + PacienteID + ", MedicoID=" + MedicoID + ", Fecha="
				+ Fecha + ", Diagnostico=" + Diagnostico + ", Tratamiento=" + Tratamiento + "]";
	}



	 

}
