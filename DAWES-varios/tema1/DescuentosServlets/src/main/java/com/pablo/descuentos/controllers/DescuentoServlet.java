package com.pablo.descuentos.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.pablo.descuentos.dtos.DescuentosDTO;
import com.pablo.descuentos.negocio.Descuentos;

/**
 * Servlet implementation class DescuentoServlet
 */
@WebServlet("/calculadescuento")
public class DescuentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DescuentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		
		Descuentos descuentos = new Descuentos();
		
		Integer descuento = descuentos.calculaDescuento(nombre);
		
		
		DescuentosDTO descuentosDTO = new DescuentosDTO(nombre,descuento);
		
//		request.setAttribute("descuento", descuento);
//		request.setAttribute("nombre", nombre);
		
		request.setAttribute("descuento", descuentosDTO);
	
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("WEB-INF/descuentovista.jsp");
		
		dispatcher.forward(request, response);
		
		
	}

}
