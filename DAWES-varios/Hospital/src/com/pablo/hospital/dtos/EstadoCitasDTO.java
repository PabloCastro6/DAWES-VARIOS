package com.pablo.hospital.dtos;

public class EstadoCitasDTO {

	private Integer ID;
	private String estado;

	public EstadoCitasDTO(Integer iD, String estado) {
		super();
		this.ID = iD;
		this.estado = estado;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
