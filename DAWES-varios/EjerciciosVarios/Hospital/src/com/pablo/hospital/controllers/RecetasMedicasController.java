package com.pablo.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.pablo.hospital.dtos.RecetasMedicasDTO;
import com.pablo.hospital.model.RecetasMedicasModelo;

public class RecetasMedicasController {

	public List<RecetasMedicasDTO> buscarRecetaMedica(String iD, String pacienteID, String medicoID,
			String medicamentoID, String fecha, String cantidadPrescrita)
			throws ClassNotFoundException, SQLException {
		RecetasMedicasModelo cm = new RecetasMedicasModelo();
		return cm.buscarRecetasMedicas(iD, pacienteID, medicoID, medicamentoID, fecha, cantidadPrescrita);
	}

	public Integer insertarRecetasMedicas(String pacienteID, String medicoID, String medicamentoID, String fecha,
			String cantidadPrescrita)
			throws ClassNotFoundException, SQLException {
		RecetasMedicasModelo cm = new RecetasMedicasModelo();
		return cm.insertarRecetasMedicas(pacienteID, medicoID, medicamentoID,fecha, cantidadPrescrita);
	}

	public Integer actualizarRecetasMedicas(String iD, String pacienteID, String medicoID, String medicamentoID,
			String fecha, String cantidadPrescrita) throws ClassNotFoundException, SQLException {

		RecetasMedicasModelo pm = new RecetasMedicasModelo();
		return pm.actualizarRecetasMedicas(iD, pacienteID, medicoID, medicamentoID, fecha, cantidadPrescrita);
	}

	

}
