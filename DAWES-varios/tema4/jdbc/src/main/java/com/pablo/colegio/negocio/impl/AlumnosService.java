package com.pablo.colegio.negocio.impl;

import java.util.List;


import com.pablo.colegio.dtos.AlumnoDTO;
import com.pablo.colegio.negocio.IAlumnosService;

public  class AlumnosService implements IAlumnosService{

	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() throws ClassNotFoundException, SQLException, NamingException {
		
		return new AlumnosDAOImplJdbc().obtenerTodosAlumnos();
	}

}
