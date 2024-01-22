package com.pablo.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.tndimpl.PeticionesDAOImplTnd;
import com.pablo.tienda.dtos.PeticionesDTO;
import com.pablo.tienda.negocio.IPeticionesService;

@Component
public class PeticionesService implements IPeticionesService{
	
	@Override
	public List<PeticionesDTO> buscarPeticiones(String iD, String iD_Cliente, String iD_Producto, String fecha,
			String cantidad, String nombreEstado) throws ClassNotFoundException, SQLException {

		return new PeticionesDAOImplTnd().buscarPeticiones(iD, iD_Cliente, iD_Producto, fecha, cantidad, nombreEstado);

	}

	@Override
	public Integer insertarPeticiones(String iD_Cliente, String iD_Producto, String cantidad, String nombreEstado)
			throws ClassNotFoundException, SQLException {

		return new PeticionesDAOImplTnd().insertarPeticiones(iD_Cliente, iD_Producto, cantidad, nombreEstado);
	}

	@Override
	public Integer actualizarPeticiones(String iD, String iD_Cliente, String iD_Producto, String cantidad,
			String fecha, String nombreEstado) throws ClassNotFoundException, SQLException {

		return new PeticionesDAOImplTnd().actualizarPeticiones(iD, iD_Cliente, iD_Producto, cantidad, fecha, nombreEstado);
	}

	@Override
	public Integer borrarPeticiones(String iD) throws ClassNotFoundException, SQLException {

		return new PeticionesDAOImplTnd().borrarPeticiones(iD);
	}

}

