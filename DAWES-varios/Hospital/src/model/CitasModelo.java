package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dtos.CitasDTO;
import dtos.PacienteDTO;
import utils.DBUtils;

public abstract class CitasModelo {
	
	public List<CitasDTO> buscaCita(Integer iD, String pacienteID, String medicoID, String fecha, String hora, String estado) throws SQLException, ClassNotFoundException {
		
		String query = " " ;
		
		Connection conexionBD = DBUtils.conexionBBDD();
		
		PreparedStatement ps = conexionBD.prepareStatement(query);
		ps.setString(1, "%" + iD + "%");
		ps.setString(2, "%" + pacienteID + "%");
		ps.setString(3, "%" + medicoID + "%");
		ps.setString(4, "%" + fecha + "%");
		ps.setString(5, "%" + hora + "%");
		ps.setString(6, "%" + estado + "%");
		
		
		
		ResultSet citasRS = ps.executeQuery();
		List<CitasDTO> listaCitas = new ArrayList<>();
		
		while(citasRS.next()) {
			CitasDTO c = new CitasDTO (citasRS.getInt("iD"), citasRS.getString("pacienteID"), citasRS.getString("medicoID"), citasRS.getString("fecha"),
					citasRS.getString("hora"), citasRS.getString("estado"));
			listaCitas.add(c); 
			listaCitas.add(c);
		}
		
		conexionBD.close();
		
		return listaCitas;
	}
	
	public  Integer insertarCita (Integer iD, String pacienteID, String medicoID, String fecha, String hora, String estado) throws SQLException, ClassNotFoundException {
	String sql = "INSERT INTO paciente (Id,  pacienteID, medicoID,  fecha, hora,  estado,\r\n"
			+ "	 fecha, hora,  estado, ) VALUES (?, ?, ?, ?, ?, ?)";
	
	Connection conexionBD = DBUtils.conexionBBDD();
	PreparedStatement ps = null;
	Integer resultado = null;
	
	ps = conexionBD.prepareStatement(sql);
	
	ps.setInt(1, iD);
	ps.setString(2, pacienteID);
	ps.setString(3, medicoID);
	ps.setString(4, fecha);
	ps.setString(5, hora);
	ps.setString(6, estado);
	
	return 0;
}

	

	
}
