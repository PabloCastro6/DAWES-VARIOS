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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pablo.tienda.dao.ICategoriasDAO;
import com.pablo.tienda.dao.IProveedorDAO;
import com.pablo.tienda.dao.tndimpl.CategoriasDAOImplTnd;
import com.pablo.tienda.dao.tndimpl.ProveedorDAOImplTnd;
import com.pablo.tienda.dtos.CategoriasDTO;
import com.pablo.tienda.dtos.ProductosDTO;
import com.pablo.tienda.dtos.ProveedorDTO;
import com.pablo.tienda.negocio.ICategoriasService;
import com.pablo.tienda.negocio.impl.CategoriasService;
import com.pablo.tienda.negocio.impl.ProductosService;

@WebServlet("/productos/modificarproductos")
public class ModificarProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ListadoProductosController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarProductosController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<CategoriasDTO> listaCategorias = new ArrayList<CategoriasDTO>();
		ICategoriasDAO comboCategoria = new CategoriasDAOImplTnd();
		
		List<ProveedorDTO> listaProveedores = new ArrayList<ProveedorDTO>();
		IProveedorDAO comboProveedores = new ProveedorDAOImplTnd();
		
		try {
			listaCategorias = comboCategoria.RecuperarCategoria();
			listaProveedores = comboProveedores.RecuperarProveedor();

		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		request.setAttribute("comboCategoria", listaCategorias);
		
		
		request.setAttribute("comboProveedores", listaProveedores);
		
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/productos/modificarProductos.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String botonEnviar = request.getParameter("enviar");
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String precio = request.getParameter("precio");
		String stock = request.getParameter("cantidadStock");
		String idCategoria = request.getParameter("idcategorias");
		String idProveedor = request.getParameter("idproveedores");
		ProductosService productoService = new ProductosService();
		
		
		if (botonEnviar != null) {
			//Buscar
	
			precio = (precio == "") ? "0" : precio;
			stock = (stock == "") ? "0" : stock;
			
			
			List<ProductosDTO> listadoProductos = new ArrayList<>();
			

			try {
				listadoProductos = productoService.buscarProducto(id, nombre, descripcion, precio, stock, idCategoria,
						idProveedor);
			} catch (ClassNotFoundException | SQLException | NamingException e) {
				logger.error("Error al buscar producto");
				e.printStackTrace();
			}

			request.setAttribute("lista", listadoProductos);

			
			
			System.out.println("productso" + listadoProductos);
			
		}else {
			//modificar

			try {
				productoService.modificarProducto(id, nombre, descripcion, precio, stock, idCategoria,
						idProveedor);
			} catch (ClassNotFoundException | SQLException | NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		doGet(request,response);
	}

}
