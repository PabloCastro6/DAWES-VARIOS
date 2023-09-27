package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dtos.AlergiaDTO;
import dtos.PacienteDTO;
import utils.DBUtils;

public class ClientesModelo {
	
	public List<PacienteDTO> buscarCliente (String id, String nombre)throws ClassNotFoundException, SQLException {
		String query = "\"SELECT * from paciente where CAST(ID AS CHAR) LIKE ? AND Descripcion LIKE ? \"";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		
		
		List<PacienteDTO> listaPacientes = new ArrayList<>();
		
		return listaPacientes;
	}

	
	public Integer insertarCliente (String nombreCliente)throws ClassNotFoundException, SQLException {
		
		String sql = "INSERT INTO cliente (Descripcion ) VALUES (?)";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		
		return 0;
	}
	
//	public Integer actualizarPaciente () {
//		
//		
//	}
	
	public Integer borrarCliente () throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM customers where customerNumber = ?";
		
		Connection connection = DBUtils.conexionBBDD();
		
		return 0;
		
	}
}
