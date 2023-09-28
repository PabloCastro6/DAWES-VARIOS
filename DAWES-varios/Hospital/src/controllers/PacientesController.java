package controllers;

import java.sql.SQLException;
import java.util.List;

import dtos.PacienteDTO;
import model.PacienteModelo;

public class PacientesController {
	
	public List<PacienteDTO> buscarPaciente(String id, String nombre, String apellido,String FechaDeNacimiento, String DNI, String direccion, String telefono,
			String correo, Integer alergia, String HistoriaMedica) throws ClassNotFoundException, SQLException {
		PacienteModelo cm = new PacienteModelo();
		return cm.buscarPaciente( id,  nombre,  apellido, FechaDeNacimiento,  DNI, direccion,  telefono,
				 correo,  alergia, HistoriaMedica);
	}
	
	public Integer insertarPaciente (String nombrePaciente) throws ClassNotFoundException, SQLException {
		PacienteModelo cm = new PacienteModelo();
		return cm.insertarPaciente(nombrePaciente);
	}
	
	
	
}
