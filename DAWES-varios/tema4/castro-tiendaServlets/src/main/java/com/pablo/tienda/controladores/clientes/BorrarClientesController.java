package com.pablo.tienda.controladores.clientes;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.pablo.tienda.negocio.IClientesService;
import com.pablo.tienda.negocio.impl.ClientesServices;




@WebServlet("/clientes/borrarclientes")
public class BorrarClientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarClientesController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		
		IClientesService clientesService = new ClientesServices();
		
		try {
			clientesService.borrarClientes(id);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/clientes/borradoClientes.jsp");
		d.forward(request, response);
	}

}
