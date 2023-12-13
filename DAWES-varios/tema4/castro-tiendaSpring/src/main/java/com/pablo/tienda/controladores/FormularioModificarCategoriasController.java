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

import com.pablo.tienda.dtos.CategoriasDTO;
import com.pablo.tienda.negocio.impl.CategoriasService;

@WebServlet("/categorias/formulariomodificarcategorias")
public class FormularioModificarCategoriasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormularioModificarCategoriasController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/modificarCategorias.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<CategoriasDTO> listadoCategorias = new ArrayList<>();

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");

		String activo = request.getParameter("activo");

		activo = (activo != null) ? "1" : "0";

		CategoriasService categoriasService = new CategoriasService();
		try {
			listadoCategorias = categoriasService.buscarCategoria(id, nombre, descripcion, activo);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("lista", listadoCategorias);

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/modificarCategorias.jsp");
		d.forward(request, response);

	}

}
