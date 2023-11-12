package com.pablo.hospital.dtos;

public class FacturacionDTO {

	private String id;
	private String pacienteID;
	private String fecha;
	private Float monto;
	private String estadoID;

	public FacturacionDTO(String id, String pacienteID, String fecha, Float monto, String estadoID) {
		super();
		this.id = id;
		this.pacienteID = pacienteID;
		this.fecha = fecha;
		this.monto = monto;
		this.estadoID = estadoID;
	}

	public FacturacionDTO(String fecha, Float monto) {
		super();
		this.fecha = fecha;
		this.monto = monto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPacienteID() {
		return pacienteID;
	}

	public void setPacienteID(String pacienteID) {
		this.pacienteID = pacienteID;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public String getEstadoID() {
		return estadoID;
	}

	public void setEstadoID(String estadoID) {
		this.estadoID = estadoID;
	}

	@Override
	public String toString() {
		return "FacturacionDTO [id=" + id + ", pacienteID=" + pacienteID + ", fecha=" + fecha + ", monto=" + monto
				+ ", estadoID=" + estadoID + "]";
	}

}
