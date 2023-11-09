package com.pablo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.pablo.negocio.CalculoCoche;

/**
 * Servlet implementation class cochesController
 */
@WebServlet("/CochesController")
public class CochesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CochesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		
		CalculoCoche calculo = new CalculoCoche();
		int numCoches = calculo.numeroDeCoches(nombre);
		
		request.setAttribute("nombre", nombre);
	    request.setAttribute("numCoches", numCoches);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp");
	    dispatcher.forward(request, response);
	}

}
