package com.pablo.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dao.tndimpl.PoblacionDAOImplTnd;
import com.pablo.tienda.dtos.PoblacionDTO;
import com.pablo.tienda.negocio.IPoblacionService;
import com.pablo.tienda.dao.IPoblacionDAO;

public class PoblacionService implements IPoblacionService {

	@Override
	public List<PoblacionDTO> recuperarPoblaciones() throws ClassNotFoundException, SQLException, NamingException {
		
		IPoblacionDAO poblacionDAO = new PoblacionDAOImplTnd();
		
		return poblacionDAO.recuperarPoblaciones();
	}

}
