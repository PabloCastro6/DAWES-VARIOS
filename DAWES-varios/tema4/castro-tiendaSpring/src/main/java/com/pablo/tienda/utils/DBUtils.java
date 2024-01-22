package com.pablo.tienda.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DBUtils {

	private static final Logger logger = LoggerFactory.getLogger(DBUtils.class) ; 


	public static Connection conectaBBDD() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String urlDB = "jdbc:mysql://localhost:3306/tienda?serverTimezone=UTC";
		String user = "root";
		String pass = "PracticaRoot";
		Connection connection = DriverManager.getConnection(urlDB, user, pass);
		logger.info("Establecida la conexión a la BBDD");
		return connection;
	}
	
	public static String cambiarFormato(String fechaOriginal) {

		DateTimeFormatter formatoOriginal = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime fecha = LocalDateTime.parse(fechaOriginal, formatoOriginal);
		DateTimeFormatter nuevoFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String fechaFormateada = fecha.format(nuevoFormato);

		return fechaFormateada;
	}
}


