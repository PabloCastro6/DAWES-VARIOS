package com.pablo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.pablo.negocio.CalculoIMC;

@WebServlet("/calcularImc")
public class IMCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public IMCController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		CalculoIMC iMC = new CalculoIMC();
		String imc = iMC.calculaIMC(nombre).toString();
		
		
		request.setAttribute("nombre", nombre);
		request.setAttribute("imc", imc);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/resultado.jsp");
		
		dispatcher.forward(request, response);
	}
}
