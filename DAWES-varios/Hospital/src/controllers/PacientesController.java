package controllers;

import java.sql.SQLException;
import java.util.List;

import dtos.PacienteDTO;
import model.ClientesModelo;

public class PacientesController {
	
	public List<PacienteDTO> buscarPaciente(String id, String nombre) throws ClassNotFoundException, SQLException {
		ClientesModelo cm = new ClientesModelo();
		return cm.buscarCliente(id,nombre);
	}
	
	public Integer insertarPaciente (String nombrePaciente) throws ClassNotFoundException, SQLException {
		ClientesModelo cm = new ClientesModelo();
		return cm.insertarCliente(nombrePaciente);
	}
	
//	public Integer actualizarPaciente (Integer id, String nombrePaciente) {
//		ClientesModelo cm = new ClientesModelo();
//		return cm.actualizarPaciente(id, nombrePaciente);
//	}
//	
	public Integer borrarCliente () {
		ClientesModelo cm = new ClientesModelo();
		return 0;
	}

}
