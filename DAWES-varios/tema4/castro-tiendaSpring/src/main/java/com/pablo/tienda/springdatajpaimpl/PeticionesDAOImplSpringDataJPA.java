package com.pablo.tienda.springdatajpaimpl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IPeticionesDAO;
import com.pablo.tienda.dtos.PeticionesDTO;
import com.pablo.tienda.repositories.PeticionesRepository;


@Component("PeticionesDAOImplSpringDataJPA")
public class PeticionesDAOImplSpringDataJPA implements IPeticionesDAO {

	@Autowired
	private PeticionesRepository preticionesRepository;

	@Override
	public List<PeticionesDTO> buscarPeticion(String idPeticiones, String idCliente, String idProducto,
			String fechaAñadido, String cantidad, String estado)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertarPeticion(String idCliente, String idProducto, String cantidad, String estado)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer actualizarPeticion(String id, String idCliente, String idProducto, String fechaAnhadido,
			String cantidad, String idEstadoPedido) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarPeticion(String idPeticiones) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}
}
