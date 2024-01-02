package com.pablo.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.CategoriasDTO;


public interface ICategoriasDAO {

    public List<CategoriasDTO> obtenerTodasCategorias() throws ClassNotFoundException, SQLException, NamingException;
	
	public List<CategoriasDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarCategoria(String id, String nombre, String descripcion, String activo)throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer actualizarCategoria(String id, String nombre, String descripcion, String activo)throws ClassNotFoundException, SQLException, NamingException;

	public Integer borrarCategoria(String id)throws ClassNotFoundException, SQLException, NamingException;
	
	public List<CategoriasDTO> RecuperarCategoria() throws ClassNotFoundException, SQLException, NamingException;
}

