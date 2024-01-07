package com.pablo.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dao.tndimpl.CategoriasDAOImplTnd;
import com.pablo.tienda.dtos.CategoriasDTO;
import com.pablo.tienda.negocio.ICategoriasService;

public class CategoriasService implements ICategoriasService{
	
	@Override
	public List<CategoriasDTO> obtenerTodasCategorias() throws ClassNotFoundException, SQLException, NamingException {
		return new CategoriasDAOImplTnd().obtenerTodasCategorias();
	}

	@Override
	public List<CategoriasDTO> buscarCategoria(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return new CategoriasDAOImplTnd().buscarCategorias(id, nombre, descripcion, activo);
	}

	@Override
	public Integer insertarCategoria( String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return new CategoriasDAOImplTnd().insertarCategoria(nombre, descripcion, activo);
	}

	@Override
	public Integer modificarCategoria(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return new CategoriasDAOImplTnd().actualizarCategoria(id, nombre, descripcion, activo);
	}

	@Override
	public Integer borrarCategoria(String id) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return new CategoriasDAOImplTnd().borrarCategoria(id);
	}
	
	

}

