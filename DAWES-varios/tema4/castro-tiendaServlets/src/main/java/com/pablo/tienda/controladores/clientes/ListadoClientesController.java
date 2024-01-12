package com.pablo.tienda.controladores.clientes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pablo.tienda.dao.IPoblacionDAO;
import com.pablo.tienda.dao.tndimpl.PoblacionDAOImplTnd;
import com.pablo.tienda.dtos.ClientesDTO;
import com.pablo.tienda.dtos.ClientesDTO;
import com.pablo.tienda.negocio.impl.ClientesService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListadoProductosController
 */
@WebServlet("/clientes/listarclientes")

public class ListadoClientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ListadoClientesController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListadoClientesController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// RECUPERACION DE COMBOS
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String poblacion = request.getParameter("poblaciones");
		poblacion = (poblacion == null || poblacion.isEmpty() ? null : poblacion);
		String activo = request.getParameter("activo");
		
		activo = (activo != null) ? "1" : "0";
		
		ClientesService clientesService = new ClientesService();
		
		try {
			if(poblacion  != null) {
				listadoClientes = clientesService.buscarClientes(id, nombre, correo, poblacion);
			}else {
				listadoClientes = clientesService.obtenerTodosClientes();
			}
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/clientes/listadoClientes.jsp");
		d.forward(request, response);
	}

	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String correoElectronico = request.getParameter("correoElectronico");
		String idPoblacion = request.getParameter("idpoblacion");
		String activo = request.getParameter("activo");

		List<ClientesDTO> listadoClientes = new ArrayList<>();
		ClientesService clienteService = new ClientesService();

		try {
			listadoClientes = clienteService.buscarCliente(id, nombre, correoElectronico, idPoblacion, activo);

		} catch (ClassNotFoundException | SQLException | NamingException e) {
			logger.error("Error al buscar cliente");
			e.printStackTrace();
		}

		request.setAttribute("lista", listadoClientes);

		System.out.println("clientes" + listadoClientes);

		
		
		// RECUPERACION DE COMBOS

		List<PoblacionDTO> listaPoblacion = new ArrayList<PoblacionDTO>();
		IPoblacionDAO comboPoblacion = new PoblacionDAOImplTnd();

		try {
			listaPoblacion = comboPoblacion.RecuperarPoblacion();

		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("comboPoblacion", listaPoblacion);
		System.out.println("1");

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/clientes/listadoClientes.jsp");
		d.forward(request, response);
	}

}