package com.pablo.tienda.controladores.clientes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dao.IPoblacionDAO;
import com.pablo.tienda.dao.tndimpl.PoblacionDAOImplTnd;
import com.pablo.tienda.dtos.PoblacionDTO;
import com.pablo.tienda.negocio.IPoblacionService;
import com.pablo.tienda.negocio.impl.ClientesService;
import com.pablo.tienda.negocio.impl.PoblacionService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/clientes/modificarcliente")
public class ModificarClientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarClientesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String idPoblacion = request.getParameter("idPoblacion");
		String activo = request.getParameter("activo");
		activo = (activo != null) ? "1":"0";
		
		ClientesService clientesService = new ClientesService();
		
		List<PoblacionDTO> listaPoblaciones = new ArrayList<PoblacionDTO>();
		IPoblacionService comboPoblaciones = new PoblacionService();
		
		try {

			listaPoblaciones = comboPoblaciones.recuperarPoblaciones();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("comboMunicipios", listaPoblaciones);
	}


}

