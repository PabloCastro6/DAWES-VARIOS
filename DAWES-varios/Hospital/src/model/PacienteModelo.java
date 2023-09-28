package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dtos.AlergiaDTO;
import dtos.PacienteDTO;
import utils.DBUtils;

public class PacienteModelo {
	
	public List<PacienteDTO> buscarPaciente (String id, String nombre, String apellido,String FechaDeNacimiento, String DNI, String direccion, String telefono,
			String correo, Integer alergia, String HistoriaMedica)throws ClassNotFoundException, SQLException {
		String query = "\"SELECT * from pacientes INNER JOIN alergias ON paciente.AlergiaID=alergias.ID where ID = ? OR nombre  LIKE ? OR Apellido LIKE ? OR FechaDeNacimiento LIKE ? OR DNI LIKE ? OR direccion LIKE ? OR telefono LIKE ? OR correo LIKE ? OR alergia LIKE ? OR historiaMedia LIKE ? OR ; \"";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		
		PreparedStatement ps = conexionBD.prepareStatement(query);
		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + apellido + "%");
		ps.setString(4, "%" + FechaDeNacimiento + "%");
		ps.setString(5, "%" + DNI + "%");
		ps.setString(6, "%" + direccion + "%");
		ps.setString(7, "%" + telefono + "%");
		ps.setString(8, "%" + correo + "%");
		ps.setString(9, "%" + alergia + "%");
		ps.setString(10, "%" + HistoriaMedica + "%");
		
		
		ResultSet pacienteRS = ps.executeQuery();
		List<PacienteDTO> listaPacientes = new ArrayList<>();
		
		
		while(pacienteRS.next()) {
			PacienteDTO p = new PacienteDTO (pacienteRS.getInt("ID"), pacienteRS.getString("nombre"), pacienteRS.getString("apellido"), pacienteRS.getString("FechaDeNacimiento"), pacienteRS.getString("DNI") , pacienteRS.getString("direccion"), pacienteRS.getString("telefono"), pacienteRS.getString("correoElectronico"), pacienteRS.getInt("AlergiaID"), pacienteRS.getString("HistoriaMedica"));
			listaPacientes.add(p);
		}
		
		conexionBD.close();
		return listaPacientes;
	}

	
	public Integer insertarPaciente (String nombre, String apellido,String FechaDeNacimiento, String DNI, String direccion, String telefono,
			String correo, Integer alergia, String HistoriaMedica)throws ClassNotFoundException, SQLException {
		
		String sql = "INSERT INTO cliente (nombre,  apellido, FechaDeNacimiento,  DNI, direccion,  telefono,\r\n"
				+ "	 correo,  alergia, HistoriaMedica ) VALUES (? ? ? ? ? ? ? ? )";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = conexionBD.prepareStatement(sql);
		
		ps.setString(1, nombre);
		ps.setString(2, apellido);
		ps.setString(3, FechaDeNacimiento);
		ps.setString(4, DNI);
		ps.setString(5, direccion);
		ps.setString(6, telefono);
		ps.setString(7,correo);
		ps.setInt(8, alergia);
		ps.setString(9, HistoriaMedica);
		
		
		
		return 0;
	}
	
	
	
	
	public Integer actualizarPaciente (Integer id, String nombrePaciente) throws SQLException, ClassNotFoundException {
		
		String sql = "UPDATE paciente SET Descripcion = CASE WHEN ? = '' THEN Descripcion ELSE ? END "
		+ "WHERE ID = ?";
		
				Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);		

		ps.setString(1, nombrePaciente);
		ps.setString(2, nombrePaciente);
		ps.setInt(3, id);
		
		resultado = ps.executeUpdate();
		
		connection.close();
		
		return resultado;
		
	}
	
	
}
