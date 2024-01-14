package com.pablo.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;


import com.pablo.tienda.dtos.ClientesDTO;
import com.pablo.tienda.dtos.ProductosDTO;

public interface IClientesService {
	
	public List<ClientesDTO> obtenerTodosClientes() throws ClassNotFoundException, SQLException, NamingException;

	List<ClientesDTO> buscarCliente(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer insertarCliente (String nombre, String correo, String poblacion, String activo)throws ClassNotFoundException, SQLException, NamingException;

}
