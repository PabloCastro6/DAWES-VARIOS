package com.pablo.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pablo.hospital.dtos.CitaDTO;
import com.pablo.hospital.dtos.PacienteDTO;
import com.pablo.hospital.utils.DBUtils;



public class CitasModelo {
	
	public List<CitaDTO> buscaCita(String id, String pacienteID, String medicoID, String fecha, String hora, String estado) throws SQLException, ClassNotFoundException {
		
		String query = "SELECT * FROM Citas WHERE ID LIKE (CASE WHEN ? = '' THEN ID ELSE ? END) AND PacienteID LIKE (CASE WHEN ? = '' THEN PacienteID ELSE ? END) "
				+ "AND MedicoID LIKE (CASE WHEN ? = '' THEN MedicoID ELSE ? END) AND Fecha LIKE (CASE WHEN ? = '' THEN Fecha ELSE ? END) "
				+ "AND Hora LIKE (CASE WHEN ? = '' THEN Hora ELSE ? END) AND Estado LIKE (CASE WHEN ? = '' THEN Estado ELSE ? END) " ;
		
		Connection conexionBD = DBUtils.conexionBBDD();
		
		PreparedStatement ps = conexionBD.prepareStatement(query);
		ps.setString(1,  id );
		ps.setString(2, '%' + id + '%' );
		ps.setString(3,  pacienteID );
		ps.setString(4, '%' + pacienteID + '%' );
		ps.setString(5,  medicoID );
		ps.setString(6, '%' + medicoID + '%' );
		ps.setString(7,  fecha );
		ps.setString(8, '%' + fecha + '%' );
		ps.setString(9,  hora );
		ps.setString(10, '%' + hora + '%' );
		ps.setString(11,  estado );
		ps.setString(12, '%' + estado + '%' );
		
		
		
		
		ResultSet citasRS = ps.executeQuery();
		List<CitaDTO> listaCitas = new ArrayList<>();
		
		while(citasRS.next()) {
			CitaDTO c = new CitaDTO (citasRS.getInt("iD"), citasRS.getString("pacienteID"), citasRS.getString("medicoID"), citasRS.getString("fecha"),
					citasRS.getString("hora"), citasRS.getString("estado"));
			listaCitas.add(c); 
			
		}
		
		conexionBD.close(); 
		
		return listaCitas;
	}
	
	public  Integer insertarCita ( String pacienteID, String medicoID, String fecha, String hora, String estadoID) throws SQLException, ClassNotFoundException {
	String sql = "INSERT INTO citas ( pacienteID, medicoID,  fecha, hora,  estadoID) VALUES (?, ?, ?, ?, ?)";
	
	Connection conexionBD = DBUtils.conexionBBDD();
	PreparedStatement ps = null;
	Integer resultado = null;
	
	ps = conexionBD.prepareStatement(sql);
	
	ps.setString(1, pacienteID);
	ps.setString(2, medicoID);
	ps.setString(3, fecha);
	ps.setString(4, hora);
	ps.setString(5, estadoID);
	
	
	resultado = ps.executeUpdate();
	conexionBD.close();
	
	return resultado;
}
	
	public Integer actualizarCita(Integer iD, String pacienteID, String medicoID, String fecha, String hora, String estadoID)
	        throws SQLException, ClassNotFoundException {
		
	    String sql = "UPDATE citas " +
	                 "SET " +
	                 "    PacienteID = CASE WHEN ? = '' THEN PacienteID ELSE ? END, " +
	                 "    MedicoID = CASE WHEN ? = '' THEN MedicoID ELSE ? END, " +
	                 "    Fecha = CASE WHEN ? = '' THEN Fecha ELSE ? END, " +
	                 "    Hora = CASE WHEN ? = '' THEN Hora ELSE ? END, " +
	                 "    EstadoID = CASE WHEN ? = '' THEN EstadoID ELSE ? END " +
	                 "WHERE ID = ?";

	    Connection connection = DBUtils.conexionBBDD();
	    PreparedStatement ps = null;
	    Integer resultado = null;

	    ps = connection.prepareStatement(sql);

	  
	    ps.setString(1, pacienteID);
	    ps.setString(2, pacienteID);
	    ps.setString(3, medicoID);
	    ps.setString(4, medicoID);
	    ps.setString(5, fecha);
	    ps.setString(6, fecha);
	    ps.setString(7, hora);
	    ps.setString(8, hora);
	    ps.setString(9, estadoID);
	    ps.setString(10, estadoID);
	    ps.setInt(11, iD);

	    resultado = ps.executeUpdate();

	    connection.close();

	    return resultado;
	}

		}

	