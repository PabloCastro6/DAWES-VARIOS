package com.pablo.colegio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.colegio.dtos.AlumnoDTO;

public interface AlumnosDAO  {
	
	public List<AlumnoDTO> obtenerTodosAlumnos() throws ClassNotFoundException, SQLException, NamingException;

}
