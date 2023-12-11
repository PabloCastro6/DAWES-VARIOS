package com.pablo.negocio.impl;

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
		return new CategoriasDAOImplTnd().buscarCategoria(id, nombre, descripcion, activo);
	}

	@Override
	public Integer insertarCategoria(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer actualizarCategoria(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

}

