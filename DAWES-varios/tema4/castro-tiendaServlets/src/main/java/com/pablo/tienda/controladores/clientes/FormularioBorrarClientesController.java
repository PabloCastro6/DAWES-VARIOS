package com.pablo.tienda.controladores.clientes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.pablo.tienda.dtos.ClientesDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;








@WebServlet("/clientes/formularioborrarclientes")
public class FormularioBorrarClientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FormularioBorrarClientesController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/clientes/borrarClientes.jsp");
		d.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ClientesDTO> listaClientes = new ArrayList();
		IPoblacionDAO combosPoblaciones = new PoblacionDAOImplTnd();

		try {
			listaClientes = combosPoblaciones.recuperaMunicipios();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		request.setAttribute("comboPoblaciones", listaClientes);
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String idPoblacion = request.getParameter("idPoblacion");
		String activo = request.getParameter("activo");
		activo = (activo != null) ? "1":"0";

		List<ClientesDTO> listadoClientes = new ArrayList<>();
		ClientesService clientesService = new ClienteService();

		try {
			listadoClientes = clientesService.buscarClientes(id, nombre, correo, idPoblacion, activo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("lista", listadoClientes);


		RequestDispatcher d = getServletContext()
				.getRequestDispatcher("/WEB-INF/clientes/borradoClientes.jsp");
		d.forward(request, response);
	}

}
