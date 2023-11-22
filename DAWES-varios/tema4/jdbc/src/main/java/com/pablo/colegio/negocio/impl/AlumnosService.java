package com.pablo.colegio.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.colegio.dao.daojdbcimpl.AlumnoDAOImlJdbc;
import com.pablo.colegio.dtos.AlumnoDTO;
import com.pablo.colegio.negocio.IAlumnosService;

public  class AlumnosService implements IAlumnosService{

	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() throws ClassNotFoundException, SQLException, NamingException {
		
		return new AlumnoDAOImlJdbc().obtenerTodosAlumnos();
	}

}
