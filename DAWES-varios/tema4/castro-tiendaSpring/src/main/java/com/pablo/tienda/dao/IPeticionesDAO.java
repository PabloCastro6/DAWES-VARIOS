package com.pablo.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.PeticionesDTO;

public interface IPeticionesDAO {

	public List<PeticionesDTO> buscarPeticion(String idPeticiones, String idCliente, String idProducto,
			String fechaAñadido, String cantidad, String estado)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarPeticion(String idCliente, String idProducto, String cantidad, String estado)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarPeticion(String id, String idCliente, String idProducto, String fechaAnhadido,
			String cantidad, String idEstadoPedido) throws ClassNotFoundException, SQLException, NamingException;

	public Integer borrarPeticion(String idPeticiones) throws ClassNotFoundException, SQLException, NamingException;



}
