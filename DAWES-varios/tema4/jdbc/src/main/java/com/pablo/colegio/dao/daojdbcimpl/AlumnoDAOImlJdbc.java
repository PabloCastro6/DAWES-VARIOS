package com.pablo.colegio.dao.daojdbcimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pablo.colegio.controladores.ControladorPruebaConexionBBDD;
import com.pablo.colegio.dao.AlumnosDAO;
import com.pablo.colegio.dtos.AlumnoDTO;
import com.pablo.colegio.utils.DBUtils;

public class AlumnoDAOImlJdbc implements AlumnosDAO {
	private static Logger logger = LoggerFactory.getLogger(ControladorPruebaConexionBBDD.class);
    

	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() throws ClassNotFoundException, SQLException, NamingException {
		
		ResultSet alumnosResultSet = null;
		List<AlumnoDTO> listaAlumnos = new ArrayList<AlumnoDTO>();
		Connection connection = DBUtils.conectaBDD();
		
		Statement st = connection.createStatement();
		alumnosResultSet = st.executeQuery("SELECT * FROM alumnos");
		
		while(alumnosResultSet.next()) {
			listaAlumnos.add(new AlumnoDTO(alumnosResultSet.getInt(1), alumnosResultSet.getString(2)));
			logger.info("añadido alumno" + alumnosResultSet.getInt(1) + " " + alumnosResultSet.getString(2));
		}
		
		return listaAlumnos;
	}

}
