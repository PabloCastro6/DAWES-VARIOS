package com.pablo.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pablo.hospital.dtos.AlergiaDTO;
import com.pablo.hospital.utils.DBUtils;



public class AlergiasModelo {
	
public List<AlergiaDTO> buscaAlergia (String id, String nombre) throws ClassNotFoundException, SQLException {
		
		String query = "SELECT * from alergias where CAST(ID AS CHAR) LIKE ? AND Descripcion LIKE ? ";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		
		PreparedStatement ps  = conexionBD.prepareStatement(query); //Creamos el PreparedStatement pasándole el String de la query por parametro
		ps.setString(1, "%" + id + "%"); 
		ps.setString(2, "%" + nombre + "%"); 
		
//		System.out.println(ps.toString());
		ResultSet alergiasRS = ps.executeQuery();	//Ejecutamos la query sobre la BBDD	
		List<AlergiaDTO> listaAlergias = new ArrayList<>(); //Creamos el arrayList para almacenar los resultados.

		while (alergiasRS.next()) {
			AlergiaDTO c = new AlergiaDTO(alergiasRS.getInt("ID"), alergiasRS.getString("Descripcion"));
			listaAlergias.add(c);
		}
		conexionBD.close();
		
		return listaAlergias;
	}

	
	public Integer insertarAlergia( String nombreAlergia) throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO alergias (Descripcion ) VALUES (?)";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);
		

		ps.setString(1, nombreAlergia);

		
		resultado = ps.executeUpdate();
		
		connection.close();
		
		return resultado;
		}
	
	public Integer actualizarAlergia(Integer id, String nombreAlergia) throws SQLException, ClassNotFoundException {

		String sql = "UPDATE alergias SET Descripcion = CASE WHEN ? = '' THEN Descripcion ELSE ? END "
				+ "WHERE ID = ?";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);		

		ps.setString(1, nombreAlergia);
		ps.setString(2, nombreAlergia);
		ps.setInt(3, id);
		

		
		resultado = ps.executeUpdate();
		
		connection.close();
		
		return resultado;
		}
	
	
}