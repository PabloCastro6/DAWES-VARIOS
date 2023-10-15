package com.pablo.hospital.dtos;

public class RecetasMedicasDTO {

	private String ID;
	private String pacienteID;
	private String MedicoID;
	private String MedicamentoID;
	private String fecha;
	private String cantidadPrescrita;

	public RecetasMedicasDTO(String iD, String pacienteID, String medicoID, String medicamentoID, String fecha,
			String cantidadPrescrita) {
		super();
		ID = iD;
		this.pacienteID = pacienteID;
		MedicoID = medicoID;
		MedicamentoID = medicamentoID;
		this.fecha = fecha;
		this.cantidadPrescrita = cantidadPrescrita;
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
		return MedicoID;
	}

	public void setMedicoID(String medicoID) {
		MedicoID = medicoID;
	}

	public String getMedicamentoID() {
		return MedicamentoID;
	}

	public void setMedicamentoID(String medicamentoID) {
		MedicamentoID = medicamentoID;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCantidadPrescrita() {
		return cantidadPrescrita;
	}

	public void setCantidadPrescrita(String cantidadPrescrita) {
		this.cantidadPrescrita = cantidadPrescrita;
	}

}