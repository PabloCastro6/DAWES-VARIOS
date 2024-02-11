package com.pablo.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.ICategoriasDAO;
import com.pablo.tienda.dtos.CategoriasDTO;
import com.pablo.tienda.negocio.ICategoriasService;

@Component
public class CategoriasService implements ICategoriasService {

//	@Autowired
//	@Qualifier("HibernateImplCategoria")
//	ICategoriasDAO categoriasDAO;

	@Autowired
	@Qualifier("CategoriasDAOImplSpringDataJPA")
	ICategoriasDAO categoriasDAO;

	@Override
	public List<CategoriasDTO> obtenerTodasCategorias() throws ClassNotFoundException, SQLException, NamingException {
		return categoriasDAO.obtenerTodasCategorias();
	}

	@Override
	public List<CategoriasDTO> buscarCategoria(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return categoriasDAO.buscarCategorias(id, nombre, descripcion, activo);
	}

	@Override
	public Integer insertarCategoria(String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return categoriasDAO.insertarCategoria(nombre, descripcion, activo);
	}

	@Override
	public Integer modificarCategoria(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return categoriasDAO.actualizarCategoria(id, nombre, descripcion, activo);
	}

	@Override
	public Integer borrarCategoria(String id) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return categoriasDAO.borrarCategoria(id);
	}

	@Override
	public List<CategoriasDTO> buscarCategoria(String id, String nombre, String descripcion, Integer estadoActivo) {
		// TODO Auto-generated method stub
		return null;
	}

}
