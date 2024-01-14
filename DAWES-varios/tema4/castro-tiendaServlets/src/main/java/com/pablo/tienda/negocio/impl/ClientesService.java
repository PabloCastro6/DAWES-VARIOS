package com.pablo.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

<<<<<<< HEAD

=======
>>>>>>> 2bd2a32303b039dc63ff177d4dc1d5bba7129039
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
	
<<<<<<< HEAD
	@Override
	public List<ClientesDTO> buscarCliente(String id, String nombre,String correo, String Poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return new ClientesDAOImplTnd().buscarCliente(id, nombre, correo,Poblacion,activo);
	}
	
	@Override
	public Integer insertarCliente( String nombre, String correo, String poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return new ClientesDAOImplTnd().insertarCliente(nombre, correo, poblacion, activo);
	}
=======
	public List<ClientesDTO> buscarProducto(String id, String nombre, String correoElectronico, String poblacion)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return new ClientesDAOImplTnd().buscarProductos(id, nombre, correoElectronico,poblacion);
	}

>>>>>>> 2bd2a32303b039dc63ff177d4dc1d5bba7129039

}
