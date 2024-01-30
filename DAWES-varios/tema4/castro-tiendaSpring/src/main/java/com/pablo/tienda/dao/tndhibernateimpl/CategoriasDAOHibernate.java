package com.pablo.tienda.dao.tndhibernateimpl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pablo.tienda.dao.ICategoriasDAO;
import com.pablo.tienda.dtos.CategoriasDTO;

@Repository  
public class CategoriasDAOHibernate implements ICategoriasDAO {

	@Override
	public List<CategoriasDTO> obtenerTodasCategorias() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriasDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertarCategoria(String nombre, String descripcion, String activo)
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

	@Override
	public Integer borrarCategoria(String id) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

}
