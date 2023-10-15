package com.pablo.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.pablo.hospital.dtos.HistorialMedicoDTO;
import com.pablo.hospital.model.HistorialMedicoModelo;

public class HistorialMedicoController {

	public List<HistorialMedicoDTO> buscarHistorialMedico(String iD, Integer pacienteID, Integer medicoID,
			String fecha, String diagnostico, String tratamiento) throws ClassNotFoundException, SQLException {
		HistorialMedicoModelo hm = new HistorialMedicoModelo();
		return hm.buscaHistorialMedico(iD, pacienteID, medicoID, fecha, diagnostico, tratamiento);
	}

	public Integer insertarHistorialPaciente(Integer pacienteID, Integer medicoID, String fecha,
			String diagnostico, String tratamiento) throws ClassNotFoundException, SQLException {
		HistorialMedicoModelo hm = new HistorialMedicoModelo();
		return hm.insertarHistorialMedico( pacienteID, medicoID, fecha, diagnostico, tratamiento);

	}

	public Integer actualizarHistorialMedico(String iD, Integer pacienteID, Integer medicoID, String fecha,
			String diagnostico, String tratamiento) throws ClassNotFoundException, SQLException {

		HistorialMedicoModelo hm = new HistorialMedicoModelo();
		return hm.actualizarHistorialMedico(iD, pacienteID, medicoID, fecha, diagnostico, tratamiento);

	}

}