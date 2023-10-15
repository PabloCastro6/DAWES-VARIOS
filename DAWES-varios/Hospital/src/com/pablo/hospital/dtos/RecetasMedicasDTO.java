package com.pablo.hospital.dtos;

public class RecetasMedicasDTO {

	private Integer ID;
	private Integer pacienteID;
	private Integer MedicoID;
	private Integer MedicamentoID;
	private String fecha;
	private Integer cantidadPrescrita;

	public RecetasMedicasDTO(Integer iD, Integer pacienteID, Integer medicoID, Integer medicamentoID, String fecha,
			Integer cantidadPrescrita) {
		super();
		ID = iD;
		this.pacienteID = pacienteID;
		MedicoID = medicoID;
		MedicamentoID = medicamentoID;
		this.fecha = fecha;
		this.cantidadPrescrita = cantidadPrescrita;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getPacienteID() {
		return pacienteID;
	}

	public void setPacienteID(Integer pacienteID) {
		this.pacienteID = pacienteID;
	}

	public Integer getMedicoID() {
		return MedicoID;
	}

	public void setMedicoID(Integer medicoID) {
		MedicoID = medicoID;
	}

	public Integer getMedicamentoID() {
		return MedicamentoID;
	}

	public void setMedicamentoID(Integer medicamentoID) {
		MedicamentoID = medicamentoID;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getCantidadPrescrita() {
		return cantidadPrescrita;
	}

	public void setCantidadPrescrita(Integer cantidadPrescrita) {
		this.cantidadPrescrita = cantidadPrescrita;
	}

}
