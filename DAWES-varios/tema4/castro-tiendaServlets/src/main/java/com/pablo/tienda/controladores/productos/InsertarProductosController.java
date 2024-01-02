package com.pablo.tienda.controladores.productos;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.negocio.impl.CategoriasService;



@WebServlet("/productos/insertarproductos")
public class InsertarProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarProductosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/productos/insertarProductos.jsp");
		d.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Integer resultado = 0;
//		String idProducto = request.getParameter("idProducto");
//		String nombre = request.getParameter("nombre");
//		String descripcion = request.getParameter("descripcion");
//        String precio = request.getParameter("precio");
//        String stock = request.getParameter("stock");
//        String idCategoria = request.getParameter("idCategoria");
//        String idProveedor = request.getParameter("idProveedor");
//		
//		try {
//			resultado = new CategoriasService().insertarCategoria(idProducto, nombre, descripcion, precio,stock,idCategoria,idProveedor);
//			
//					} catch (ClassNotFoundException | SQLException | NamingException e) {
//			
//			e.printStackTrace();
//		}
//		
//		request.setAttribute("resultado", resultado);
//		
//		doGet(request, response);
	}

}
