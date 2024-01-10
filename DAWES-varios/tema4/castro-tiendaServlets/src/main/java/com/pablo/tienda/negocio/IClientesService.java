package com.pablo.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;


import com.pablo.tienda.dtos.ClientesDTO;

public interface IClientesService {
	
	public List<ClientesDTO> obtenerTodosClientes() throws ClassNotFoundException, SQLException, NamingException;

}
