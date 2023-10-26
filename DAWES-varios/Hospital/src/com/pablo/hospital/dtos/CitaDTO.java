package com.pablo.hospital.dtos;

public class CitaDTO {
	private String ID;
	private String pacienteID;
	private String medicoID;
	private String fecha;
	private String hora;
	private String estadoID;

	public CitaDTO(String iD, String pacienteID, String medicoID, String fecha, String hora, String estadoID) {
		super();
		ID = iD;
		this.pacienteID = pacienteID;
		this.medicoID = medicoID;
		this.fecha = fecha;
		this.hora = hora;
		this.estadoID = estadoID;

	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
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
		return estadoID;
	}

	public void setEstado(String estado) {
		this.estadoID = estado;
	}

	@Override
	public String toString() {
		return "CitaDTO [ID=" + ID + ", pacienteID=" + pacienteID + ", medicoID=" + medicoID + ", fecha=" + fecha
				+ ", hora=" + hora + ", estadoID=" + estadoID + "]";
	}

	
	
}
