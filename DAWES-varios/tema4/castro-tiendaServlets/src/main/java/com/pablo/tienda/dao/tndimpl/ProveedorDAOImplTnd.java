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

import com.pablo.tienda.dao.IProveedorDAO;
import com.pablo.tienda.dtos.CategoriasDTO;
import com.pablo.tienda.dtos.ProveedorDTO;
import com.pablo.tienda.utils.DBUtils;

public class ProveedorDAOImplTnd implements IProveedorDAO {
	private static final Logger logger = LoggerFactory.getLogger(ProveedorDAOImplTnd.class) ; 

	@Override
	public List<ProveedorDTO> RecuperarProveedor() throws ClassNotFoundException, SQLException, NamingException {
		
		String sql = "SELECT ID_Proveedor, Nombre FROM Proveedores ORDER BY ID_Proveedor ";
		List<ProveedorDTO> listaProveedores = new ArrayList<ProveedorDTO>();
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaProveedores.add(new ProveedorDTO(rs.getInt(1), rs.getString(2)));
			logger.info("añadida categoria " + rs.getInt(1)+ " " + rs.getString(2)  );
		
		}
		return listaProveedores;
	
	}

}
