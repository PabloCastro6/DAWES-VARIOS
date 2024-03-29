package com.pablo.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.PeticionesDTO;

public interface IPeticionesService {

	public List<PeticionesDTO> buscarPeticiones(String idPeticiones, String idCliente, String idProducto,
			String fechaAñadido, String cantidad, String estado)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarPeticiones(String idCliente, String idProducto, String cantidad, String estado)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarPeticiones(String idPeticiones, String idCliente, String idProducto, String fechaAnhadido,
			String cantidad, String estado) throws ClassNotFoundException, SQLException, NamingException;

	public Integer borrarPeticiones(String idPeticiones) throws ClassNotFoundException, SQLException, NamingException;

}
