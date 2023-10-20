package com.pablo.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.pablo.hospital.dtos.PacienteDTO;
import com.pablo.hospital.model.PacienteModelo;

public class PacientesController {

	public List<PacienteDTO> buscarPaciente(String id, String nombre, String apellido, String FechaDeNacimiento,
			String DNI, String direccion, String telefono, String correo, String alergia, String HistoriaMedica)
			throws ClassNotFoundException, SQLException {
		PacienteModelo cm = new PacienteModelo();
		return cm.buscarPaciente(id, nombre, apellido, FechaDeNacimiento, DNI, direccion, telefono, correo, alergia,
				HistoriaMedica);
	}

	public Integer insertarPaciente(String nombre, String apellido, String FechaDeNacimiento, String DNI,
			String direccion, String telefono, String correo, String alergiaID, String HistoriaMedica)
			throws ClassNotFoundException, SQLException {
		PacienteModelo cm = new PacienteModelo();
		return cm.insertarPaciente(nombre, apellido, FechaDeNacimiento, DNI, direccion, telefono, correo, alergiaID,
				HistoriaMedica);
	}

	public Integer actualizarPaciente(String id, String nombre, String apellido, String FechaDeNacimiento, String DNI,
			String direccion, String telefono, String correo, String alergiaID, String HistoriaMedica)
			throws ClassNotFoundException, SQLException {

		PacienteModelo pm = new PacienteModelo();
		return pm.actualizarPaciente(nombre, apellido, FechaDeNacimiento, DNI, direccion, telefono, correo, alergiaID,
				HistoriaMedica);
	}

}
