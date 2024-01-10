package com.pablo.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.PoblacionDTO;



public interface IPoblacionDAO {
	public List<PoblacionDTO> RecuperarPoblacion() throws ClassNotFoundException, SQLException, NamingException;

}
