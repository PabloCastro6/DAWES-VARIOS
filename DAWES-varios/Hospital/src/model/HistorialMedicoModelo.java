package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dtos.HistorialMedicoDTO;
import utils.DBUtils;

public class HistorialMedicoModelo {
	
	public List<HistorialMedicoDTO> buscaHistorialMedico (Integer iD, Integer pacienteID, Integer medicoID, String fecha, String diagnostico,
			String tratamiento) throws SQLException, ClassNotFoundException { 
		
		String query = "SELECT * FROM HistorialMedico " +
	               "WHERE " +
	               "(PacienteID = CASE WHEN ? = '' THEN PacienteID ELSE ? END OR PacienteID LIKE ?) " +
	               "AND (MedicoID = CASE WHEN ? = '' THEN MedicoID ELSE ? END OR MedicoID LIKE ?) " +
	               "AND (Fecha = CASE WHEN ? = '' THEN Fecha ELSE ? END OR Fecha LIKE ?) " +
	               "AND (Diagnostico = CASE WHEN ? = '' THEN Diagnostico ELSE ? END OR Diagnostico LIKE ?) " +
	               "AND (Tratamiento = CASE WHEN ? = '' THEN Tratamiento ELSE ? END OR Tratamiento LIKE ?)";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		
		PreparedStatement ps = conexionBD.prepareStatement(query);
		
		ps.setInt(1, iD);
		ps.setInt(2, '%' + iD + '%' );
		ps.setInt(3, pacienteID);
		ps.setInt(4, '%' + pacienteID + '%' );
		ps.setInt(5, medicoID);
		ps.setInt(6, '%' + medicoID + '%' );
		ps.setString(7,fecha);
		ps.setString(8, '%' + fecha + '%' );
		ps.setString(9,diagnostico);
		ps.setString(10, '%' + diagnostico + '%' );
		ps.setString(11,tratamiento);
		ps.setString(12, '%' + tratamiento + '%' );
		
		ResultSet historialRS = ps.executeQuery();
		List<HistorialMedicoDTO> listaHistorial = new ArrayList<>();
		
		while (historialRS.next()) {
			HistorialMedicoDTO h = new HistorialMedicoDTO(historialRS.getInt("iD"),historialRS.getInt("pacienteID"), historialRS.getInt("medicoID"), historialRS.getString("fecha"),
					historialRS.getString("diagnostico"), historialRS.getString("tratamiento"));
			listaHistorial.add(h);
		}
		
		conexionBD.close();
		
		return listaHistorial;
		
	}
	
	public Integer insertarHistorialMedico (Integer iD, Integer pacienteID, Integer medicoID, String fecha, String diagnostico,
			String tratamiento) throws ClassNotFoundException, SQLException {
		
		String sql = "INSERT INTO HistorialMedico (iD, PacienteID, MedicoID, Fecha, Diagnostico, Tratamiento) VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = conexionBD.prepareStatement(sql);
		
		return resultado;
		
	}
	
	public Integer actualizarHistorialMedico (Integer iD, Integer pacienteID, Integer medicoID, String fecha, String diagnostico,
			String tratamiento) throws ClassNotFoundException, SQLException {
		
		String sql = "UPDATE HistorialMedico " +
	             "SET " +
	             "    PacienteID = CASE WHEN ? = '' THEN PacienteID ELSE ? END, " +
	             "    MedicoID = CASE WHEN ? = '' THEN MedicoID ELSE ? END, " +
	             "    Fecha = CASE WHEN ? = '' THEN Fecha ELSE ? END, " +
	             "    Diagnostico = CASE WHEN ? = '' THEN Diagnostico ELSE ? END, " +
	             "    Tratamiento = CASE WHEN ? = '' THEN Tratamiento ELSE ? END " +
	             "WHERE ID = ?";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1, iD);
		ps.setInt(2, iD);
		ps.setInt(3,pacienteID);
		ps.setInt(4, pacienteID);
		ps.setInt(5, medicoID);
		ps.setInt(6, medicoID);
		ps.setString(7, fecha);
		ps.setString(8, fecha);
		ps.setString(9, diagnostico);
		ps.setString(10, diagnostico);
		ps.setString(11, tratamiento);
		ps.setString(12, tratamiento);
		
		resultado = ps.executeUpdate();
		
		connection.close();
		
		return resultado;
		
		

	}

}
