package com.pablo.tienda.springdatajpaimpl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.ICategoriasDAO;
import com.pablo.tienda.dtos.CategoriasDTO;
import com.pablo.tienda.entities.CategoriasEntity;
import com.pablo.tienda.repositories.CategoriasRepository;

@Component("CategoriasDAOImplSpringDataJPA")
public class CategoriasDAOImplSpringDataJPA implements ICategoriasDAO {

	@Autowired
	private CategoriasRepository categoriasRepository;

	@Override
	public List<CategoriasDTO> obtenerTodasCategorias() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriasDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		Integer activoInt = activo.equals("1") ? 1 : 0; 
		
	    return categoriasRepository.buscaCategorias(nombre, descripcion, activoInt);
	}

	@Override
	public Integer insertarCategoria(String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		CategoriasEntity c = new CategoriasEntity(nombre,descripcion,Integer.parseInt(activo));
		
		categoriasRepository.save(c);
		return c.getId();
	}

	@Override
	public Integer actualizarCategoria(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		CategoriasEntity c = new CategoriasEntity(Integer.parseInt(activo),nombre,descripcion,Integer.parseInt(activo));
		
		categoriasRepository.save(c);
		return c.getId();
	}

	@Override
	public Integer borrarCategoria(String id) throws ClassNotFoundException, SQLException, NamingException {
		
		
	
		
		return null;
	}

}
