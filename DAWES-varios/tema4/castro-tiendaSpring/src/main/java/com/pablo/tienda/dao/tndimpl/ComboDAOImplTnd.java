package com.pablo.tienda.dao.tndimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IComboDAO;
import com.pablo.tienda.dtos.ComboDTO;
import com.pablo.tienda.utils.DBUtils;

@Component 
public class ComboDAOImplTnd implements IComboDAO {
	
	public List<ComboDTO> recuperaCombosCategorias() throws ClassNotFoundException, SQLException, NamingException {

		String sql = "SELECT ID_Categoria, Nombre FROM categorias ORDER BY Nombre";

		List<ComboDTO> listaCategorias = new ArrayList<>();

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			listaCategorias.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		connection.close();
		return listaCategorias;
	}

	public List<ComboDTO> recuperaCombosProveedores() throws ClassNotFoundException, SQLException, NamingException {

		String sql = "SELECT ID_Proveedor, Nombre FROM proveedores ORDER BY Nombre";

		Connection connection = DBUtils.conectaBBDD();
		List<ComboDTO> listaProveedores = new ArrayList<>();

		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaProveedores.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		
		connection.close();
		return listaProveedores;
	}

	
	
	@Override
	public List<ComboDTO> recuperaComboMunicipios() throws ClassNotFoundException, SQLException {
		String sql = "SELECT ID, Nombre FROM poblacion ORDER BY ID";

		Connection connection = DBUtils.conectaBBDD();
		List<ComboDTO> listaPoblaciones = new ArrayList<>();

		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaPoblaciones.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		
		connection.close();
		return listaPoblaciones;
	
	}
	}

	


