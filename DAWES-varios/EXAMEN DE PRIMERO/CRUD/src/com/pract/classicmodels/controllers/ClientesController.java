package com.pract.classicmodels.controllers;

import java.sql.SQLException;
import java.util.List;

import com.pract.classicmodels.dtos.ClienteDTO;
import com.pract.classicmodels.model.ClientesModelo;

public class ClientesController {
	
	public List<ClienteDTO> recuperaDatos(Integer id) throws ClassNotFoundException, SQLException{
		ClientesModelo cm = new ClientesModelo();
		return cm.recuperaDatos(id);
	}
	
	
	
	public Integer insertarCliente(String nombre, String direccion, String apellido, String telefon) throws ClassNotFoundException, SQLException {
		
		ClientesModelo cm = new ClientesModelo();
		return cm.insertarCliente(nombre, direccion, apellido, telefon);
	}
	
	public Integer actualizarCliente(String nombreCliente, String apellidoCliente, String direccion,
			String telefono, Integer id_usuario) throws ClassNotFoundException, SQLException {
		
		ClientesModelo cm = new ClientesModelo();
		return cm.actualizarCliente(nombreCliente, apellidoCliente, direccion, telefono, id_usuario);
	}
	
	public Integer borrarCliente(int numerocliente) throws ClassNotFoundException, SQLException {
		
		ClientesModelo cm = new ClientesModelo();
		return cm.borrarCliente(numerocliente);
	}

}
