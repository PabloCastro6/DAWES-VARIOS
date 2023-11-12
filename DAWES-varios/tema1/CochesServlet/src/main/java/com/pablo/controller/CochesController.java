package com.pablo.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pablo.negocio.CalculoC;


@WebServlet("/CochesController")
public class CochesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CochesController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		CalculoC calculo = new CalculoC();
		Integer cantidad = calculo.calculaCoches(nombre);
		
		request.setAttribute("nombre", nombre);
		request.setAttribute("cantidad", cantidad);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/resultado.jsp");
		
		dispatcher.forward(request, response);
		
	}
}
