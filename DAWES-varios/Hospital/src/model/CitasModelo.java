package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dtos.CitasDTO;
import utils.DBUtils;

public class CitasModelo {
	
	public List<CitasDTO> buscaCita(Integer iD, String pacienteID, String medicoID, String fecha, String hora, String estado) {
		
		String query = "SELECT * from citas " ;
		
		Connection conexionBD = DBUtils.conexionBBDD();
		
		PreparedStatement ps = conexionBD.prepareStatement(query);
		
		
		ResultSet citasRS = ps.executeQuery();
		List<CitasDTO> listaCitas = new ArrayList<>();
		
		while(citasRS.next()) {
			CitasDTO c = ;
			listaCitas.add(c);
		}
		
		conexionBD.close();
		
		return listaCitas;
	}
	
	public Integer insertarCita ()

}
