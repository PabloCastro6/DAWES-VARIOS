package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dtos.EstadoFacturacionDTO;
import utils.DBUtils;

public class EstadoFacturacionModelo {
	
	public List<EstadoFacturacionDTO> buscarEstadoFacturacion(String iD, String estado) throws ClassNotFoundException, SQLException {
		
		String query = "SELECT * FROM estadofacturacion WHERE ID LIKE ? AND Estado LIKE ?";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		
		PreparedStatement ps =conexionBD.prepareStatement(query);
		ps.setString(1, "%" + iD + "%");
		ps.setString(2, "%" + estado + "%");
		
		ResultSet EstadoFacturacionRS = ps.executeQuery();
		List<EstadoFacturacionDTO> listaEstadoFacturacion = new ArrayList<>();
		
		while (EstadoFacturacionRS.next()) {
			EstadoFacturacionDTO e = new EstadoFacturacionDTO (EstadoFacturacionRS.getInt("iD"), EstadoFacturacionRS.getString("estado"));
			
			listaEstadoFacturacion.add(e);
			 
			 
		}
		
		conexionBD.close();
		
		return listaEstadoFacturacion;
	}
	
	public Integer insertarEstadoFacturacion ( String estado) {
		
		String sql = "INSERT INTO EstadoFacturacion (Estado) VALUES (?);";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = conexionBD.prepareStatement(sql);
		
		ps.setString(1, estado);
	
		
		
		resultado = ps.executeUpdate();
		conexionBD.close();
		
		return resultado;
	}
		
	public Integer actualizarCita(String iD, String estado) throws SQLException, ClassNotFoundException {
		
	    String sql = "UPDATE estadofacturacion " +
	                 "SET " +
	                 "    estado = CASE WHEN ? = '' THEN estado ELSE ? END, " +
	                 "WHERE ID = ?";

	    Connection connection = DBUtils.conexionBBDD();
	    PreparedStatement ps = null;
	    Integer resultado = null;

	    ps = connection.prepareStatement(sql);

	  
	    ps.setString(1, estado);
	    ps.setInt(2, ID);
	    

	    resultado = ps.executeUpdate();

	    connection.close();

	    return resultado;
	}
	}

}
