package com.pablo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pablo.dto.ClienteDTO;
import com.pablo.utils.DBUtils;



public class ClientesModelo {

	public void crearCliente(ClienteDTO cliente) throws SQLException, ClassNotFoundException {
		Connection connection = DBUtils.conectar();

		PreparedStatement stmt = connection.prepareStatement("INSERT INTO clientes (ID_Cliente, Nombre, Dirección, Teléfono) VALUES (?,?,?,?)");

		stmt.setInt(1, cliente.getIdCliente());
		stmt.setString(2, cliente.getNombre());
		stmt.setString(3, cliente.getDireccion());
		stmt.setString(4, cliente.getTelefono());

		stmt.executeUpdate();

	}
	

	public void leerCliente(int idLeer) throws SQLException, ClassNotFoundException {
		Connection connection = DBUtils.conectar();
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM clientes c JOIN facturas f WHERE c.ID_Cliente=? AND f.ID_Cliente=c.ID_Cliente");
		stmt.setInt(1, idLeer);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			ClienteDTO clienteDTO = new ClienteDTO(rs.getInt("ID_Cliente"), rs.getString("Nombre"),
					rs.getString("Dirección"), rs.getString("Teléfono"), rs.getInt("ID_Factura"), rs.getDate("Fecha"),
					rs.getDouble("Monto"));

			System.out.println(clienteDTO);

		}

	}

	public void actualizarCliente(ClienteDTO cliente) throws SQLException, ClassNotFoundException {
		Connection connection = DBUtils.conectar();

		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM clientes  WHERE ID_Cliente=?");
		stmt.setInt(1, cliente.getIdCliente());

		ResultSet rs = stmt.executeQuery();
		ClienteDTO clienteDTOActualizar = null;
		while (rs.next()) {

			clienteDTOActualizar = new ClienteDTO(rs.getInt("ID_Cliente"), rs.getString("Nombre"),
					rs.getString("Dirección"), rs.getString("Teléfono"));

		}

		if (clienteDTOActualizar != null) {

			if (cliente.getNombre().isEmpty()) {
				cliente.setNombre(clienteDTOActualizar.getNombre());
			}

			if (cliente.getTelefono().isEmpty()) {
				cliente.setTelefono(clienteDTOActualizar.getTelefono());
			}

			if (cliente.getDireccion().isEmpty()) {
				cliente.setDireccion(clienteDTOActualizar.getDireccion());
			}

			PreparedStatement stmtUpdate = connection.prepareStatement("UPDATE clientes SET ID_Cliente=?,Nombre=?, Dirección=?, Teléfono=? where ID_Cliente=?");

			stmtUpdate.setInt(1, cliente.getIdCliente());
			stmtUpdate.setString(2, cliente.getNombre());
			stmtUpdate.setString(3, cliente.getDireccion());
			stmtUpdate.setString(4, cliente.getTelefono());
			stmtUpdate.setInt(5, cliente.getIdCliente());

			stmtUpdate.executeUpdate();
		}

	}

}
