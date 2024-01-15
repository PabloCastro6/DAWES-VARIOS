package com.pablo.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.CategoriasDTO;
import com.pablo.tienda.dtos.ClientesDTO;


public interface IClientesService {
	

	List<ClientesDTO> obtenerTodosClientes() throws ClassNotFoundException, SQLException, NamingException;
	
	List<ClientesDTO> buscarCliente(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer insertarClientes (String nombre, String correo, String poblacion, String activo)throws ClassNotFoundException, SQLException, NamingException;

	
	public Integer actualizarClientes(String id, String nombre, String correo, String idPoblacion,
			String activo) throws ClassNotFoundException, SQLException;
	
	public Integer borrarClientes(String id)throws ClassNotFoundException, SQLException;


}
