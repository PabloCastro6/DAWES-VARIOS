package com.pablo.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.ICategoriasDAO;
import com.pablo.tienda.dao.tndimpl.ClientesDAOImplTnd;
import com.pablo.tienda.dtos.ClienteDTO;
import com.pablo.tienda.negocio.IClientesService;

@Component
public class ClientesServices implements IClientesService {

	
	@Autowired
	@Qualifier("HibernateImplCliente")
	ICategoriasDAO categoriasDAO;

	@Override
	public List<ClienteDTO> buscarClientes(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {

		return new ClientesDAOImplTnd().buscarClientes(id, nombre, correo, idPoblacion, activo);
	}

	@Override
	public Integer insertarClientes(String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {

		return new ClientesDAOImplTnd().insertarClientes(nombre, correo, idPoblacion, activo);
	}

	@Override
	public Integer modificarClientes(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {

		return new ClientesDAOImplTnd().actualizarClientes(id, nombre, correo, idPoblacion, activo);
	}

	@Override
	public Integer borrarClientes(String id) throws ClassNotFoundException, SQLException {

		return new ClientesDAOImplTnd().borrarClientes(id);
	}

}
