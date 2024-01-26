package com.pablo.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import com.pablo.tienda.dtos.ClienteDTO;

public interface IClientesService {

	public List<ClienteDTO> buscarClientes(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException;

	public Integer insertarClientes(String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException;

	public Integer modificarClientes(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException;

	public Integer borrarClientes(String id) throws ClassNotFoundException, SQLException;

}
