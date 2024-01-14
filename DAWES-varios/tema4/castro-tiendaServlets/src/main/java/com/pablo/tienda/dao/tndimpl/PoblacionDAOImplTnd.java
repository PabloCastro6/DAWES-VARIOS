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
	public List<PoblacionDTO> RecuperarPoblacion() throws ClassNotFoundException, SQLException, NamingException {
		
		String sql = "SELECT ID, Nombre FROM Poblacion ORDER BY ID ";
		
		List<PoblacionDTO> listaPoblaciones = new ArrayList<>();
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaPoblaciones.add(new PoblacionDTO(rs.getInt(1), rs.getString(2)));
			logger.info("añadida poblacion " + rs.getInt(1)+ " " + rs.getString(2)  );
		
		}
		connection.close();
		return listaPoblaciones;
	
	}


}
