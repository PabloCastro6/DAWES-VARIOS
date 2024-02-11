package com.pablo.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.ICategoriasDAO;
import com.pablo.tienda.dao.IPeticionesDAO;
import com.pablo.tienda.dtos.PeticionesDTO;
import com.pablo.tienda.negocio.IPeticionesService;

@Component
public class PeticionesService implements IPeticionesService {

//	@Autowired
//	@Qualifier("HibernateImplPeticion")
//	IPeticionesDAO peticionesDAO;

	@Autowired
	@Qualifier("PeticionesDAOImplSpringDataJPA")
	IPeticionesDAO peticionesDAO;

	@Override
	public List<PeticionesDTO> buscarPeticiones(String idPeticiones, String idCliente, String idProducto,
			String fechaAñadido, String cantidad, String estado)
			throws ClassNotFoundException, SQLException, NamingException {
		return peticionesDAO.buscarPeticion(idPeticiones, idCliente, idProducto, fechaAñadido, cantidad, estado);
	}

	@Override
	public Integer insertarPeticiones(String idCliente, String idProducto, String cantidad, String estado)
			throws ClassNotFoundException, SQLException, NamingException {
		return peticionesDAO.insertarPeticion(idCliente, idProducto, cantidad, estado);
	}

	@Override
	public Integer actualizarPeticiones(String id, String idCliente, String idProducto, String fechaAnhadido,
			String cantidad, String idEstadoPedido) throws ClassNotFoundException, SQLException, NamingException {
		return peticionesDAO.actualizarPeticion(id, idCliente, idProducto, fechaAnhadido, cantidad, idEstadoPedido);
	}

	@Override
	public Integer borrarPeticiones(String idPeticiones) throws ClassNotFoundException, SQLException, NamingException {
		return peticionesDAO.borrarPeticion(idPeticiones);
	}
}
