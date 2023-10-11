package com.pablo.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pablo.hospital.dtos.AlergiaDTO;
import com.pablo.hospital.dtos.PacienteDTO;
import com.pablo.hospital.utils.DBUtils;



public class PacienteModelo {
	
	public List<PacienteDTO> buscarPaciente (String id, String nombre, String apellido,String FechaDeNacimiento, String DNI, String direccion, String telefono,
			String correo, String alergiaID, String HistoriaMedica)throws ClassNotFoundException, SQLException {
		
		String query = "SELECT pacientes.* , alergias.ID AS alergia_ID, alergias.Descripcion FROM pacientes INNER JOIN alergias ON pacientes.AlergiaID=alergias.ID where (pacientes.ID LIKE ? or Nombre LIKE ? OR Apellido LIKE ? OR FechaDeNacimiento LIKE ? OR DNI LIKE ? OR Direccion LIKE ? "
				+ "OR Telefono LIKE ? OR CorreoElectronico LIKE ? OR alergias.ID LIKE ? OR HistoriaMedica LIKE ?)";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		
		PreparedStatement ps = conexionBD.prepareStatement(query);
		ps.setString(1,  id );
		ps.setString(2,  nombre );
		ps.setString(3,  apellido );
		ps.setString(4,  FechaDeNacimiento);
		ps.setString(5,  DNI );
		ps.setString(6,  direccion );
		ps.setString(7,  telefono );
		ps.setString(8,  correo );
		ps.setString(9,  alergiaID );
		ps.setString(10,  HistoriaMedica );
		
		
		ResultSet pacienteRS = ps.executeQuery();
		List<PacienteDTO> listaPacientes = new ArrayList<>();
		
		
		while(pacienteRS.next()) {
			PacienteDTO p = new PacienteDTO (pacienteRS.getInt("Id"), pacienteRS.getString("nombre"), pacienteRS.getString("apellido"), pacienteRS.getString("FechaDeNacimiento"), pacienteRS.getString("DNI") , pacienteRS.getString("direccion"),
					pacienteRS.getString("telefono"), pacienteRS.getString("correoElectronico"), pacienteRS.getString("descripcion"), pacienteRS.getString("HistoriaMedica"));
			listaPacientes.add(p);
		}
		
		conexionBD.close();
		return listaPacientes;
	}

	
	public Integer insertarPaciente (String nombre, String apellido,String FechaDeNacimiento, String DNI, String direccion, String telefono,
			String correo, Integer alergiaID, String HistoriaMedica)throws ClassNotFoundException, SQLException {
		
		String sql = "INSERT INTO pacientes (nombre,  apellido, FechaDeNacimiento,  DNI, direccion,  telefono"
				+ "	 correo,  alergia, HistoriaMedica ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
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
		ps.setInt(8, alergiaID);
		ps.setString(9, HistoriaMedica);
		
		 resultado = ps.executeUpdate();
		
		conexionBD.close();
		
		return resultado;
	}
	
	
	
	
	public Integer actualizarPaciente (String nombre, String apellido,String FechaDeNacimiento, String DNI, String direccion, String telefono,
			String correo, Integer alergiaID, String HistoriaMedica) throws SQLException, ClassNotFoundException {
		
		String sql = " UPDATE pacientes SET Nombre = CASE WHEN ? = '' THEN Nombre ELSE ? END," +
			  "  Apellido = CASE WHEN ? = '' THEN Apellido ELSE ? END," +
			    	 "   FechaDeNacimiento = CASE WHEN ? = '' THEN FechaDeNacimiento ELSE ? END," +
			    	  "  DNI = CASE WHEN ? = '' THEN DNI ELSE ? END," + 
			    	 "   Direccion = CASE WHEN ? = '' THEN Direccion ELSE ? END," +
			    	   " Telefono = CASE WHEN ? = '' THEN Telefono ELSE ? END," + 
			    	   " CorreoElectronico = CASE WHEN ? = '' THEN CorreoElectronico ELSE ? END," +
			    	   " AlergiaID = CASE WHEN ? = '' THEN AlergiaID ELSE ? END," + 
			    	  "  HistoriaMedica = CASE WHEN ? = '' THEN HistoriaMedica ELSE ? END " +
			    	   "WHERE ID = ?;";

		
				Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);		

		ps.setString(1, nombre);
		ps.setString(2, apellido);
		ps.setString(3, FechaDeNacimiento);
		ps.setString(4, DNI);
		ps.setString(5, direccion);
		ps.setString(6, telefono);
		ps.setString(7, correo);
		ps.setInt(8, alergiaID);
		ps.setString(9, HistoriaMedica);
		
		
		
		resultado = ps.executeUpdate();
		
		connection.close();
		
		return resultado;
		
	}
	
	
}
