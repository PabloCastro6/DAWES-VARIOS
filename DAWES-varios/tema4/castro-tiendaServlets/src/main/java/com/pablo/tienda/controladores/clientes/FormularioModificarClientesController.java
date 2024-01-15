package com.pablo.tienda.controladores.clientes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.ClientesDTO;
import com.pablo.tienda.dtos.PoblacionDTO;
import com.pablo.tienda.negocio.IPoblacionService;
import com.pablo.tienda.negocio.impl.ClientesService;
import com.pablo.tienda.negocio.impl.PoblacionService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/clientes/formulariomodificarcliente")
public class FormularioModificarClientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioModificarClientesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PoblacionDTO> listaPoblaciones = new ArrayList<PoblacionDTO>();
		IPoblacionService comboPoblaciones = new PoblacionService();
		
		try {

			listaPoblaciones = comboPoblaciones.recuperarPoblaciones();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("comboPoblacion", listaPoblaciones);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/clientes/modificarClientes.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<PoblacionDTO> listaPoblaciones = new ArrayList<PoblacionDTO>();
		IPoblacionService comboPoblaciones = new PoblacionService();
		
		try {

			listaPoblaciones = comboPoblaciones.recuperarPoblaciones();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("comboPoblacion", listaPoblaciones);

		
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String idPoblacion = request.getParameter("idPoblacion");
		String activo = request.getParameter("activo");
		activo = (activo != null) ? "1":"0";

		List<ClientesDTO> listadoClientes = new ArrayList<>();
		ClientesService clientesService = new ClientesService();

		try {
			listadoClientes = clientesService.buscarCliente(id, nombre, correo, idPoblacion, activo);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("lista", listadoClientes);


		RequestDispatcher d = getServletContext()
				.getRequestDispatcher("/WEB-INF/vistas/clientes/modificarClientes.jsp");
		d.forward(request, response);
		
		
		
	}
	

}
