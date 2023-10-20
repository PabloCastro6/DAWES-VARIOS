package com.pablo.hospital.dtos;

public class HabitacionesDTO {
	private String ID;
	private String tipo;
	private String estado;
	private Float costoPorDia;

	public HabitacionesDTO(String iD, String tipo, String estado, Float costoPorDia) {
		super();
		ID = iD;
		this.tipo = tipo;
		this.estado = estado;
		this.costoPorDia = costoPorDia;
	}

	public HabitacionesDTO(String tipo, String estado, Float costoPorDia) {
		super();
		this.tipo = tipo;
		this.estado = estado;
		this.costoPorDia = costoPorDia;
	}

	public HabitacionesDTO() {
		super();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Float getCostoPorDia() {
		return costoPorDia;
	}

	public void setCostoPorDia(Float costoPorDia) {
		this.costoPorDia = costoPorDia;
	}

	@Override
	public String toString() {
		return "HabitacionesDTO [ID=" + ID + ", tipo=" + tipo + ", estado=" + estado + ", costoPorDia=" + costoPorDia
				+ "]";
	}

}
