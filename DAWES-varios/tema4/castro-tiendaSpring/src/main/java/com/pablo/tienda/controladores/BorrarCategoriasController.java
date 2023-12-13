package com.pablo.tienda.controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.pablo.tienda.negocio.ICategoriasService;
import com.pablo.tienda.negocio.impl.CategoriasService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/categorias/borrarcategorias")
public class BorrarCategoriasController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/borrarCategorias.jsp");
		d.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("id");
			
			ICategoriasService categoriasService = new CategoriasService();

			try {
				categoriasService.borrarCategoria(id);
			} catch (ClassNotFoundException | SQLException | NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/borrarCategorias.jsp");
			d.forward(request, response);
		}

	}
	
	
