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

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.sql.DataSource;

import com.pablo.colegio.dtos.AlumnoDTO;
import com.pablo.colegio.negocio.impl.AlumnosService;
import com.pablo.colegio.utils.DBUtils;

@WebServlet("/alumnos/obtenertodosalumnos")
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
	
		
			List<AlumnoDTO> listaAlumnos = null;
			
	
			
			try {
				listaAlumnos = new AlumnosService().obtenerTodosAlumnos();
				
			}catch(ClassNotFoundException | SQLException | NamingException e) {
				e.printStackTrace();
			}
			request.setAttribute("listaAlumnos", listaAlumnos);
			RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumnos.jsp");
			d.forward(request, response);
			
			
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
