package com.pract.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pract.classicmodels.dtos.ClienteDTO;
import com.pract.classicmodels.utils.DBUtils;

public class ClientesModelo {
	
	public  List<ClienteDTO> recuperaDatos(Integer codigo) throws ClassNotFoundException, SQLException {
		Connection conexionBD = DBUtils.conexionBBDD();
		
		String query = "SELECT numero_cuenta, saldo, nombre, apellido, direccion, telefono  FROM clientes  INNER JOIN cuentas ON clientes.id_usuario = ? ";

		PreparedStatement ps  = conexionBD.prepareStatement(query);

		ps.setString(1, "%" + codigo + "%");

		ResultSet clientes = ps.executeQuery();	//Ejecutamos la query sobre la BBDD

		List<ClienteDTO> listaClientes = new ArrayList<>();
		
		while (clientes.next()) {
			ClienteDTO c = new ClienteDTO(clientes.getString("nombre"), clientes.getString("telefono")
					, clientes.getString("apellido"), clientes.getString("direccion"));
			listaClientes.add(c);
		}
		conexionBD.close();
		
		return listaClientes;
	}


	public Integer insertarCliente(String nombre, String direccion, String apellido, String telefono) throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO clientes (nombre, apellido, direccion, telefono) "
					+ "VALUES (?, ?, ?, ?)";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);
		
		ps.setString(1, nombre);
		ps.setString(2, apellido);
		ps.setString(3, direccion);
		ps.setString(4, telefono);

		
		resultado = ps.executeUpdate();
		
		connection.close();
		
		return resultado;
		}
	
	public Integer actualizarCliente(String nombreCliente, String apellidoCliente, String direccion,
			String telefono, Integer id_usuario) throws SQLException, ClassNotFoundException {

		String sql = "UPDATE clientes SET nombre = CASE WHEN ? = '' THEN customerName ELSE ? END,"
				+ "apellido  = CASE WHEN ? = '' THEN contactLastName ELSE ? END,"
				+ "direccion = CASE WHEN ? = '' THEN contactFirstName ELSE ? END, "
				+ "telefono = CASE WHEN ? = '' THEN phone ELSE ? END, "
				+ "WHERE nombre = ?";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);		

		ps.setString(1, nombreCliente);
		ps.setString(2, nombreCliente);
		
		ps.setString(3, apellidoCliente);
		ps.setString(4, apellidoCliente);
		
		ps.setString(5, direccion);
		ps.setString(6, direccion);
		
		ps.setString(7, telefono);
		ps.setString(8, telefono);
		
		ps.setInt(9, id_usuario);
		ps.setInt(10, id_usuario);
		

		resultado = ps.executeUpdate();
		
		connection.close();
		
		return resultado;
		}
	
	public Integer borrarCliente(int customerNumber) throws ClassNotFoundException, SQLException {
		
		String sql = "DELETE FROM customers where id_usuario = ?";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);		

		ps.setInt(1, customerNumber);
	
		resultado = ps.executeUpdate();
		
		connection.close();
		
		return resultado;
		
		
	}
}
