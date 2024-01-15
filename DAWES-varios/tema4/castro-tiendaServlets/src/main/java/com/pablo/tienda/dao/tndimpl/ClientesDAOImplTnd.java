package com.pablo.tienda.dao.tndimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;


import com.pablo.tienda.dao.IClientesDAO;
import com.pablo.tienda.dtos.ClientesDTO;
import com.pablo.tienda.utils.DBUtils;

public class ClientesDAOImplTnd implements IClientesDAO {
	
	

	
	@Override 
	public List<ClientesDTO> buscarCliente (String id, String nombre, String correo,String poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = null;
		
		if(poblacion.equals("")) {
			sql = "SELECT c.ID_Cliente, c.Nombre, c.CorreoElectronico, p.Nombre, c.`ID_Poblacion`, c.activo "
					+ " FROM cliente c " + " INNER JOIN poblacion p " + " ON p.ID = c.ID_Poblacion "
					+ " WHERE c.ID_Cliente LIKE ? AND c.Nombre LIKE ? AND c.CorreoElectronico LIKE ?  "
					+ " AND c.activo = ?";
		} else {
			sql =  "SELECT c.ID_Cliente, c.Nombre, c.CorreoElectronico, p.Nombre, c.ID_Poblacion, c.activo "
					+ " FROM cliente c " + " INNER JOIN poblacion p " + " ON p.ID = c.ID_Poblacion "
					+ " WHERE c.ID_Cliente LIKE ? AND c.Nombre LIKE ? AND c.CorreoElectronico LIKE ? "
					+ " AND c.ID_Poblacion = ? AND c.activo = ? ";
		}
		
		Connection connection = DBUtils.conectaBBDD();
		List<ClientesDTO> listaClientes = new ArrayList<>();
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		if(poblacion.equals("")) {
			ps.setString(1,  "%" + id + "%");
			ps.setString(2,  "%" + nombre + "%");
			ps.setString(3,  "%" + correo + "%");
			ps.setString(4, activo);
			
			
		} else {
			ps.setString(1,  "%" + id + "%");
			ps.setString(2,  "%" + nombre + "%");
			ps.setString(3,  "%" + correo + "%");
			ps.setString(4, poblacion);
			ps.setString(5, activo);
			
		}
		System.out.println(ps.toString());
		ResultSet clientesRS = ps.executeQuery();
		while (clientesRS.next()) {
			
		}
		
		{
			connection.close();
			return listaClientes;
			
		}
		
		
	}
	
	@Override
	public Integer insertarClientes(String nombre, String correo, String poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {

		String sql = "INSERT INTO clientes (Nombre,CorreoElectronico,ID_Poblacion,activo) VALUES (?, ?, ?, ?) ";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		
		ps.setString(1, nombre);
		ps.setString(2, correo);
		ps.setString(3, poblacion);
		ps.setString(4, activo);
		

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}


	@Override
	public Integer actualizarClientes(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {

		String sql = "UPDATE clientes SET Nombre = ?, CorreoElectronico = ?, ID_Poblacion = ?, activo = ? WHERE ID_Cliente = ? ";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, correo);
		ps.setString(3, idPoblacion);
		ps.setString(4, activo);
		ps.setString(5, id);

		Integer resultado = ps.executeUpdate();
		ps.toString();
		System.out.println(ps.toString());
		connection.close();

		return resultado;
	}

	@Override
	public Integer borrarClientes(String id) throws ClassNotFoundException, SQLException {

		String sql = "UPDATE clientes SET activo = 0 "
				+ " WHERE ID_Cliente = ? ";
		
		Connection connection = DBUtils.conectaBBDD();
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, id);
		
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}


	
}

