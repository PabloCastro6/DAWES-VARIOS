package com.pablo.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.pablo.hospital.dtos.HabitacionesDTO;
import com.pablo.hospital.utils.DBUtils;

public class HabitacionesModelo {
	
	public List<HabitacionesDTO> buscarHabitacion (Integer iD, String tipo, String estado, Float costoPorDia) throws SQLException, ClassNotFoundException {
		
		String query = "";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBD.prepareStatement(query);
		ps.setString(1, "%" + iD + "%");
		ps.setString(2, "%" + tipo + "%");
		ps.setString(3, "%" + estado + "%");
		ps.setString(4, "%" + costoPorDia + "%");
		
		ResultSet habitacionesRS = ps.executeQuery();
		
		
		
	}

}
