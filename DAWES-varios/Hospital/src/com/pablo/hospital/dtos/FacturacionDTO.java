package com.pablo.hospital.dtos;

public class FacturacionDTO {
	
	private Integer id;
	private Integer pacienteID;
	private String fecha;
	private Float monto;
	private Integer estadoID;
	
	
	public FacturacionDTO(Integer id, Integer pacienteID, String fecha, Float monto, Integer estadoID) {
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


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getPacienteID() {
		return pacienteID;
	}


	public void setPacienteID(Integer pacienteID) {
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


	public Integer getEstadoID() {
		return estadoID;
	}


	public void setEstadoID(Integer estadoID) {
		this.estadoID = estadoID;
	}


	@Override
	public String toString() {
		return "FacturacionDTO [id=" + id + ", pacienteID=" + pacienteID + ", fecha=" + fecha + ", monto=" + monto
				+ ", estadoID=" + estadoID + "]";
	}
	
	
	
	

}
