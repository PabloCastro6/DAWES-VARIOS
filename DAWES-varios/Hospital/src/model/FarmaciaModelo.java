package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dtos.FarmaciaDTO;
import utils.DBUtils;

public class FarmaciaModelo {
	
	public List<FarmaciaDTO> buscaFarmacia(Integer medicamento, String nombre, String descripcion, Integer cantidadDisponible, Float precio) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM farmacia ";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps  = conexionBD.prepareStatement(query);
		ps.setString(1, "%" + medicamento + "%"); 
		ps.setString(2, "%" + nombre + "%"); 
		ps.setString(3, "%" + descripcion + "%"); 
		ps.setString(4, "%" + cantidadDisponible + "%"); 
		ps.setString(5, "%" + precio + "%"); 
		
		ResultSet farmaciasRS = ps.executeQuery();
		List<FarmaciaDTO> listaFarmacia = new ArrayList<>();
		
		
		while (farmaciasRS.next()) {
			FarmaciaDTO f = new FarmaciaDTO(farmaciasRS.getInt("medicamento"), farmaciasRS.getString("nombre"), farmaciasRS.getString("descripcion"), farmaciasRS.getInt("cantidadDisponible"), farmaciasRS.getFloat("precio"));
			listaFarmacia.add(f);
		}
		
		conexionBD.close();
		
		return listaFarmacia;
	}
	
	public Integer insertarFarmacia (Integer medicamento, String nombre, String descripcion, Integer cantidadDisponible, Float precio) throws ClassNotFoundException, SQLException {
		
		String sql = "INSERT INTO farmacias (Descripcion) VALUES (?)";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1,medicamento);
		ps.setString(2,nombre);
		ps.setString(3,descripcion);
		ps.setInt(4,cantidadDisponible);
		ps.setFloat(5,precio);
		
		resultado = ps.executeUpdate();
		
		connection.close();
		
		
		
		
		return resultado;
	}

}
