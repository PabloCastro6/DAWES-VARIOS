package com.pablo.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;


import com.pablo.tienda.dao.tndimpl.ClientesDAOImplTnd;
import com.pablo.tienda.dtos.ClientesDTO;
import com.pablo.tienda.negocio.IClientesService;

public class ClientesService implements IClientesService {


	
	@Override
	public List<ClientesDTO> buscarCliente(String id, String nombre,String correo, String Poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return new ClientesDAOImplTnd().buscarCliente(id, nombre, correo,Poblacion,activo);
	}
	
	@Override
	public Integer insertarClientes(String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {

		return new ClientesDAOImplTnd().insertarClientes( nombre, correo, idPoblacion, activo);
	}

	@Override
	public Integer actualizarClientes(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {

		return new ClientesDAOImplTnd().actualizarClientes(id, nombre, correo, idPoblacion, activo);
	}

	@Override
	public Integer borrarClientes(String id) throws ClassNotFoundException, SQLException {

		return new ClientesDAOImplTnd().borrarClientes(id);
	}


}
