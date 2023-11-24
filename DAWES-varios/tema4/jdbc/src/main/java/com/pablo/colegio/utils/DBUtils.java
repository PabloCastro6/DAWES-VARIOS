package com.pablo.colegio.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.pablo.colegio.controladores.ControladorPruebaConexionBBDD;

public class DBUtils {
	
	private static Logger logger = LoggerFactory.getLogger(DBUtils.class);
	
	// public static Connection conectaBDD() throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		String urlDB= "jdbc:mysql://localhost:3306/colegio?serverTimezone=UTC";
//		String user = "root";
//		String pass = "1234";
//		Connection connection = DriverManager.getConnection(urlDB, user, pass);
//		logger.info("Establecida la conexion a la BBDD");
//		return connection;
//	}
	
	public static Connection conectaBDD() throws ClassNotFoundException, SQLException, NamingException {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/miBBDD");
		
		Connection con = ds.getConnection();
		return con;
}
}
