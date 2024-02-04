package com.pablo.tienda.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBUtils {

	private static final Logger logger = LoggerFactory.getLogger(DBUtils.class);

	private static SessionFactory sessionFactory;

	public static SessionFactory creadorSessionFactory() {

		if (sessionFactory == null) {
			try {
				sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Error al crear el objeto SessionFactory" + ex);
				throw new ExceptionInInitializerError(ex);
			}

		}

		return sessionFactory;
	}

	public static Connection conectaBBDD() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String urlDB = "jdbc:mysql://localhost:3306/tienda?serverTimezone=UTC";
		String user = "root";
		String pass = "1234";
		Connection connection = DriverManager.getConnection(urlDB, user, pass);
		logger.info("Establecida la conexión a la BBDD");
		return connection;
	}

//	public static Connection conectaBBDD() throws ClassNotFoundException, SQLException, NamingException {
//	
//		Context  ctx = new InitialContext();
//		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyLocalDB");
//		
//		Connection con = ds.getConnection();
//		return con;
//	}
}
