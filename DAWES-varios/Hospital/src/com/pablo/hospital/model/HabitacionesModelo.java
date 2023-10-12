package com.pablo.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pablo.hospital.dtos.HabitacionesDTO;
import com.pablo.hospital.dtos.PacienteDTO;
import com.pablo.hospital.utils.DBUtils;

public class HabitacionesModelo {
	
	public List<HabitacionesDTO> buscarHabitacion (Integer iD, String tipo, String estado, Float costoPorDia) throws SQLException, ClassNotFoundException {
		
		String query = "SELECT * FROM habitaciones WHERE iD LIKE ? OR tipo LIKE ? OR estado LIKE ? OR costoPorDia LIKE ?;";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBD.prepareStatement(query);
		ps.setInt(1,  iD );
		ps.setString(2,  tipo );
		ps.setString(3,  estado );
		ps.setFloat(4,  costoPorDia);
		
		ResultSet habitacionesRS = ps.executeQuery();
		List<HabitacionesDTO> listaHabitaciones = new ArrayList<>();
		
		while(habitacionesRS.next()) {
			HabitacionesDTO p = new HabitacionesDTO (habitacionesRS.getInt("iD"), habitacionesRS.getString("tipo"), habitacionesRS.getString("estado"), habitacionesRS.getFloat("costoPorDia"));
			listaHabitaciones.add(p);
		}
		
		conexionBD.close();
		return listaHabitaciones;
	}
	
	public Integer insertarHabitaciones( String tipo, String estado, Float costoPorDia) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO habitaciones ( tipo, estado, costoPorDia) VALUES (?, ?, ?)";

		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = conexionBD.prepareStatement(sql);

		ps.setString(1, tipo);
		ps.setString(2, estado);
		ps.setFloat(3, costoPorDia);

		resultado = ps.executeUpdate();

		conexionBD.close();

		return resultado;
	}
	
	public Integer actualizarHabitacion(Integer iD, String tipo, String estado, Float costoPorDia) throws SQLException, ClassNotFoundException {

		String sql = " UPDATE habitaciones SET tipo = CASE WHEN ? = '' THEN tipo ELSE ? END,"
				+ "  estado = CASE WHEN ? = '' THEN estado ELSE ? END,"
				+ " costoPorDia = CASE WHEN ? = '' THEN costoPorDia ELSE ? END," + " WHERE ID = ?;";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, tipo);
		ps.setString(2, tipo);
		ps.setString(3, estado);
		ps.setString(4, estado);
		ps.setFloat(5, costoPorDia);
		ps.setFloat(6, costoPorDia);
		ps.setInt(7, iD);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;

	}
		
	}


