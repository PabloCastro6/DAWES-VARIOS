package com.pablo.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dao.tndimpl.ClientesDAOImplTnd;
import com.pablo.tienda.dtos.ClientesDTO;
import com.pablo.tienda.dtos.ProductosDTO;
import com.pablo.tienda.negocio.IClientesService;

public class ClientesService implements IClientesService {

	@Override
	public List<ClientesDTO> obtenerTodosClientes() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<ClientesDTO> buscarProducto(String id, String nombre, String correoElectronico, String poblacion)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return new ClientesDAOImplTnd().buscarProductos(id, nombre, correoElectronico,poblacion);
	}


}
