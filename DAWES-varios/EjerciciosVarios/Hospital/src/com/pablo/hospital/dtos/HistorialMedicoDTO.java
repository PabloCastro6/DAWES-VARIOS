package com.pablo.hospital.dtos;

public class HistorialMedicoDTO {

	private String ID;
	private String PacienteID;
	private String MedicoID;
	private String Fecha;
	private String Diagnostico;
	private String Tratamiento;

	public HistorialMedicoDTO(String iD, String pacienteID, String medicoID, String fecha, String diagnostico,
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

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPacienteID() {
		return PacienteID;
	}

	public void setPacienteID(String pacienteID) {
		PacienteID = pacienteID;
	}

	public String getMedicoID() {
		return MedicoID;
	}

	public void setMedicoID(String medicoID) {
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
