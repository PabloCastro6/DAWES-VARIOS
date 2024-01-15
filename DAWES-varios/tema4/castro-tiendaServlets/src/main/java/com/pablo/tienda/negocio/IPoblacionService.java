package com.pablo.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.ClientesDTO;
import com.pablo.tienda.dtos.PoblacionDTO;

public interface IPoblacionService {
	
	public List<PoblacionDTO> recuperarPoblaciones() throws ClassNotFoundException, SQLException, NamingException;

}
