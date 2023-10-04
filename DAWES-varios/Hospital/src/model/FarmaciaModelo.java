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
	
	public List<FarmaciaDTO> buscaFarmacia(String medicamento, String nombre, String descripcion, String cantidadDisponible, String precio) throws SQLException, ClassNotFoundException {
		String query = "\"SELECT * FROM farmacia WHERE \" +\r\n"
				+ " \"Medicamento LIKE ? AND \" +\r\n"
				+ " \"Nombre LIKE ? AND \" +\r\n"
				+ "   \"Descripcion LIKE ? AND \" +\r\n"
				+  "\"CantidadDisponible LIKE ? AND \" +\r\n"
				+ "  \"Precio LIKE ?\"; ";
		
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
	
	public Integer insertarFarmacia (String medicamento, String nombre, String descripcion, String cantidadDisponible, String precio) throws ClassNotFoundException, SQLException {
		
		String sql = "\"INSERT INTO farmacia (Medicamento, Nombre, Descripcion, CantidadDisponible, Precio) \" + VALUES (?, ?, ?, ?, ?)\"";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = connection.prepareStatement(sql);
		
		ps.setString(1,medicamento);
		ps.setString(2,nombre);
		ps.setString(3,descripcion);
		ps.setString(4,cantidadDisponible);
		ps.setString(5,precio);
		
		resultado = ps.executeUpdate();
		
		connection.close();
		
		
		
		
		return resultado;
	}

	public Integer actualizarFarmacia(Integer medicamento, String nombre, String descripcion, Integer cantidadDisponible, Float precio) throws SQLException, ClassNotFoundException {

		String sql = "UPDATE farmacia SET Medicamento = ?, Nombre = ?, Descripcion = ?, CantidadDisponible = ?, Precio = ? \" +\r\n"
				+ "                 \"WHERE ID = ?\"";  
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);		

		ps.setInt(1, medicamento);
		ps.setInt(2, medicamento);
		
		ps.setString(3, nombre);
		ps.setString(4, nombre);
		
		ps.setString(5, descripcion);
		ps.setString(6, descripcion);
		
		ps.setInt(7, cantidadDisponible);
		ps.setInt(8, cantidadDisponible);
		
		ps.setInt(9, cantidadDisponible);
		ps.setInt(10, cantidadDisponible);
		
		ps.setFloat(11, precio);
		ps.setFloat(12, precio);
	
		
		resultado = ps.executeUpdate();
		
		connection.close();
		
		return resultado;
		}

}
