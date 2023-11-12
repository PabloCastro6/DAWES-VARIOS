package com.pablo.hospital.dtos;

public class EstadoCitasDTO {

	private String ID;
	private String estado;

	public EstadoCitasDTO(String iD, String estado) {
		super();
		this.ID = iD;
		this.estado = estado;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
