package com.pablo.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.CategoriasDTO;
import com.pablo.tienda.dtos.ProveedorDTO;

public interface IProveedorDAO {
	
	public List<ProveedorDTO> RecuperarProveedor() throws ClassNotFoundException, SQLException, NamingException;

}
