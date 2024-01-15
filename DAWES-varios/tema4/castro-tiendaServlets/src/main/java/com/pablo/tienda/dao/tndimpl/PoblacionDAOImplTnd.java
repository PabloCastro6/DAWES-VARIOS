package com.pablo.tienda.dao.tndimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pablo.tienda.dao.IPoblacionDAO;
import com.pablo.tienda.dtos.PoblacionDTO;
import com.pablo.tienda.utils.DBUtils;



public class PoblacionDAOImplTnd implements IPoblacionDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ProveedorDAOImplTnd.class) ; 

	@Override
	public List<PoblacionDTO> RecuperarPoblacion() throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM poblacion ORDER BY nombre";
		
		List<PoblacionDTO>listaPoblacion = new ArrayList<>();
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) {
			listaPoblacion.add(new PoblacionDTO(rs.getInt(1), rs.getString(2)));
		}
		connection.close();
		return listaPoblacion;
	}

}