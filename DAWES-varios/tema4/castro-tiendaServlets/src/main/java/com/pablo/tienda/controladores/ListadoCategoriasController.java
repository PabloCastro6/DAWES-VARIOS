package com.pablo.tienda.controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.pablo.tienda.dtos.CategoriasDTO;
import com.pablo.tienda.negocio.impl.CategoriasService;


/**
 * Servlet implementation class ListadoCategoriasController
 */
@WebServlet("/categorias/listarcategorias")
public class ListadoCategoriasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ListadoCategoriasController.class) ; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoCategoriasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/listadoCategorias.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		
		String activo = request.getParameter("activo");
		
		
		activo = (activo != null) ? "1" : "0";
		
		
		List<CategoriasDTO> listadoCategorias = new ArrayList<>();			
		CategoriasService categoriaService = new CategoriasService();
		
		try {
			listadoCategorias = categoriaService.buscarCategoria(id, nombre, descripcion, activo);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("lista", listadoCategorias);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/listadoCategorias.jsp");
		d.forward(request, response);
		
	}

}
