package com.pablo.colegio.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.colegio.dtos.AlumnoDTO;

public interface IAlumnosService {
	
	public List<AlumnoDTO> obtenerTodosAlummnos() throws ClassNotFoundException, SQLException, NamingException;

}

