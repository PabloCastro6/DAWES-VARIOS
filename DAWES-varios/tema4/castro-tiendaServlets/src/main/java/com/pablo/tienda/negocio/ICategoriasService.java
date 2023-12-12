package com.pablo.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.CategoriasDTO;


public interface ICategoriasService {

public List<CategoriasDTO> obtenerTodasCategorias() throws ClassNotFoundException, SQLException, NamingException;
	
	public List<CategoriasDTO> buscarCategoria(String id, String nombre, String descripcion, String activo) throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarCategoria(String id, String nombre, String descripcion, String activo)throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer modificarCategoria(String id, String nombre, String descripcion, String activo)throws ClassNotFoundException, SQLException, NamingException;

}
