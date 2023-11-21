package com.pablo.colegio.controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pablo.colegio.dtos.AlumnoDTO;

@WebServlet("/pruebaconexion")
public class ControladorPruebaConexionBBDD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(ControladorPruebaConexionBBDD.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorPruebaConexionBBDD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ResultSet alumnosResultSet = null;
		List<AlumnoDTO> listaAlumnos = new ArrayList<AlumnoDTO>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String urlDB= "jdbc:mysql://localhost:3306/colegio?serverTimezone=UTC";
			String user = "root";
			String pass = "PracticaRoot";
			Connection connection = DriverManager.getConnection(urlDB, user, pass);
			logger.info("Establecida la conexion a la BBDD");
			
			Statement st = connection.createStatement();
			alumnosResultSet = st.executeQuery("SELECT * FROM alumnos");
			
			while(alumnosResultSet.next()) {
				listaAlumnos.add(new AlumnoDTO(alumnosResultSet.getInt(0), alumnosResultSet.getString(1)));
				logger.info("añadido alumno" + alumnosResultSet.getInt(0) + " " + alumnosResultSet.getString(1));
			}
			
			request.setAttribute("litaAlumnos", listaAlumnos);
			
			RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumnos.jsp");
			d.forward(request, response);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
