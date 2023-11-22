package com.pablo.colegio.negocio;

import java.util.List;

import com.pablo.colegio.dtos.AlumnoDTO;
import com.pablo.colegio.negocio.impl.NamingException;
import com.pablo.colegio.negocio.impl.SQLException;

public interface IAlumnosService {
	
	public List<AlumnoDTO> obtenerTodosAlumnos()  {
		return new AlumnoDAOImlJdbc().obtenerTodosAlumnos();
	}
	
		
	}


