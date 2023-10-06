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
		
		String query = "";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		
		PreparedStatement ps =conexionBD.prepareStatement(query);
		ps.setString(1, "%" + iD + "%");
		ps.setString(2, "%" + estado + "%");
		
		ResultSet EstadoFacturacionRS = ps.executeQuery();
		List<EstadoFacturacionDTO> listaEstadoFacturacion = new ArrayList<>();
		
		while (EstadoFacturacionRS.next()) {
			EstadoFacturacionDTO e = new EstadoFacturacionDTO (EstadoFacturacionRS.getInt("iD"), EstadoFacturacionRS.getString("estado"));
			
			listaEstadoFacturacion.add(e);
			listaEstadoFacturacion.add(e);
		}
		
		conexionBD.close();
		
		return listaEstadoFacturacion;
	}

}
