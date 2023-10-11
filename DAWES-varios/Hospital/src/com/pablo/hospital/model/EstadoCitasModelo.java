package com.pablo.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pablo.hospital.dtos.EstadoCitasDTO;

import utils.DBUtils;

public class EstadoCitasModelo {
	
	public List<EstadoCitasDTO> buscarEstadoCitas (String iD, String estado) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM estadocitas WHERE ? lIKE ?";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		
		PreparedStatement ps = conexionBD.prepareStatement(query);
		
		ps.setString(1,  "%" + iD + "%");
		ps.setString(2, "%" + estado + "%");
		
		
		ResultSet EstadoCitasRS = ps.executeQuery();
		List<EstadoCitasDTO> listaEstadoCitas = new ArrayList<>();
		
		
		while(EstadoCitasRS.next()) {
			EstadoCitasDTO e = new EstadoCitasDTO(EstadoCitasRS.getInt("iD"), EstadoCitasRS.getString("estado"));
			listaEstadoCitas.add(e);
		}
		
		conexionBD.close();
		
		return listaEstadoCitas;
	}

	public Integer insertarEstadoCitas( String iD, String estado) throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO estadocitas (Descripcion ) VALUES (?, ?)";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);
		

		ps.setString(1, iD);
		ps.setString(2, estado);

		
		resultado = ps.executeUpdate();
		
		connection.close();
		
		return resultado;
		}
	
	public Integer actualizarEstadoCitas(String id, String estado) throws SQLException, ClassNotFoundException {

		String sql = "UPDATE estadocitas SET Descripcion = CASE WHEN ? = '' THEN Descripcion ELSE ? END "
				+ "WHERE ID = ?";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);		

		ps.setString(1, estado);
		ps.setString(2, estado);
		ps.setString(3, id);
		

		
		resultado = ps.executeUpdate();
		
		connection.close();
		
		return resultado;
		}
}
