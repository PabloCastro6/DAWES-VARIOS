package com.pablo.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.CategoriasDTO;
import com.pablo.tienda.dtos.ClientesDTO;

public interface IClientesDAO {

public List<ClientesDTO> obtenerTodasCategorias() throws ClassNotFoundException, SQLException, NamingException;
	

public List<ClientesDTO> buscarCliente(String id, String nombre, String correo, String poblacion, String activo) throws ClassNotFoundException, SQLException, NamingException;

public Integer insertarCliente(String nombre, String correo, String poblacion, String activo)throws ClassNotFoundException, SQLException, NamingException;

}
