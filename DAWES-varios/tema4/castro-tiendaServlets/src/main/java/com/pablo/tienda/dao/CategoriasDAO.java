package com.pablo.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.CategoriasDTO;


public interface CategoriasDAO {

public List<CategoriasDTO> obtenerTodasCategorias() throws ClassNotFoundException, SQLException, NamingException;
	
	public List<CategoriasDTO> buscarCategorias(Integer id, String nombre, String descripcion, String activo)throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarCategoria(Integer id, String nombre, String descripcion, String activo)throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer actualizarCategoria(Integer id, String nombre, String descripcion, String activo)throws ClassNotFoundException, SQLException, NamingException;
}
