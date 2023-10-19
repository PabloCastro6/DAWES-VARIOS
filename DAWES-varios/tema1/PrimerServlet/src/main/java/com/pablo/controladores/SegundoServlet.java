package com.pablo.controladores;

import com.pablo.app.negocio.NumeroAleatorio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * Servlet implementation class SegundoServlet
 */

@WebServlet("/SegundoServicio") 
public class SegundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SegundoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NumeroAleatorio numeroAleatorio = new NumeroAleatorio();
		double numero = numeroAleatorio.numeroAletario();
		
		PrintWriter out = response.getWriter();
		
		out.print("<html> <body>");
		out.print("<h1>Hola </h1> ");
		out.print("<p>Numero Random:" + numero +"</p>");
		out.print("</body> </html>");
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
