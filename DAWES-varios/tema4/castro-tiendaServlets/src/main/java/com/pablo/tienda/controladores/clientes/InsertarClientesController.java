package com.pablo.tienda.controladores.clientes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dao.IPoblacionDAO;
import com.pablo.tienda.dao.tndimpl.PoblacionDAOImplTnd;
import com.pablo.tienda.dtos.ClientesDTO;
import com.pablo.tienda.dtos.PoblacionDTO;
import com.pablo.tienda.negocio.impl.ClientesService;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/clientes/insertarclientes")
public class InsertarClientesController  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertarClientesController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<PoblacionDTO> listaPoblaciones = new ArrayList<PoblacionDTO>();
		IPoblacionDAO comboPoblacion = new PoblacionDAOImplTnd();
		
		try {
			listaPoblaciones = comboPoblacion.RecuperarPoblacion();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("comboPoblacion", listaPoblaciones);
			
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String poblacion = request.getParameter("poblaciones");
		poblacion = (poblacion == null || poblacion.isEmpty() ? null : poblacion);
		String activo = request.getParameter("activo");
		
		activo = (activo != null) ? "1" : "0";
		
		
		List<ClientesDTO> listadoClientes = new ArrayList<>();
		ClientesService clientesService = new ClientesService();
		
		
		
		try {
			 if(poblacion  != null) {
				listadoClientes = clientesService.buscarCliente(id,nombre, correo, poblacion,activo);
			}else {
		 listadoClientes = clientesService.obtenerTodosClientes();
		}
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("lista", listadoClientes);

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/clientes/insertarClientes.jsp");
		d.forward(request, response);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer resultado = 0;
		

		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String idPoblacion = request.getParameter("poblacion");
		String activo = request.getParameter("activo");
		
		activo = (activo != null) ? "1":"0";

		try {
			resultado = new ClientesService().insertarCliente(nombre, correo, idPoblacion, activo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("resultado", resultado);
		
		doGet(request, response);
	}
	
	
}		
		
		
//		// RECUPERACION DE COMBOS
//
//		List<PoblacionDTO> listaPoblacion = new ArrayList<PoblacionDTO>();
//		IPoblacionDAO comboPoblacion = new PoblacionDAOImplTnd();
//
//		try {
//			listaPoblacion = comboPoblacion.RecuperarPoblacion();
//
//		} catch (ClassNotFoundException | SQLException | NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		request.setAttribute("comboPoblacion", listaPoblacion);
//		
//	
//	
//	}






