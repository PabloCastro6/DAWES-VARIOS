package com.pablo.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.ClienteDTO;

public interface IClientesDAO {

	public List<ClienteDTO> buscarClientes(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException;

	public Integer insertarClientes(String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException;

	public Integer actualizarClientes(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException;

	public Integer borrarClientes(String id) throws ClassNotFoundException, SQLException;

}
