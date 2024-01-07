 package com.pablo.tienda.controladores.productos;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import com.pablo.tienda.negocio.impl.CategoriasService;
import com.pablo.tienda.negocio.impl.ProductosService;

/**
 * Servlet implementation class ListadoProductosController
 */
@WebServlet("/productos/listarproductos")
public class ListadoProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ListadoProductosController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListadoProductosController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	
	//RECUPERACION DE COMBOS
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
		System.out.println("1");
		
		request.setAttribute("comboProveedores", listaProveedores);
		System.out.println("2");
		
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/productos/listadoProductos.jsp");
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
		String descripcion = request.getParameter("descripcion");
		String precio = request.getParameter("precio");
		String stock = request.getParameter("cantidadStock");
		String idCategoria = request.getParameter("idcategorias");
		String idProveedor = request.getParameter("idproveedores");

		precio = (precio == "") ? "0" : precio;
		stock = (stock == "") ? "0" : stock;
		
		
		List<ProductosDTO> listadoProductos = new ArrayList<>();
		ProductosService productoService = new ProductosService();

		try {
			listadoProductos = productoService.buscarProducto(id, nombre, descripcion, precio, stock, idCategoria,
					idProveedor);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			logger.error("Error al buscar producto");
			e.printStackTrace();
		}

		request.setAttribute("lista", listadoProductos);

		
		
		
		
		//RECUPERACION DE COMBOS

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
		System.out.println("1");
		
		request.setAttribute("comboProveedores", listaProveedores);
		System.out.println("2");
		
		RequestDispatcher d = getServletContext()
				.getRequestDispatcher("/WEB-INF/vistas/productos/listadoProductos.jsp");
		d.forward(request, response);
	}
	
}
	
	
	
	
//	private void recuperarCombos (HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//		List<ComboDTO> listaCategoria = new ArrayList();
//		IComboDAO combosCategorias = new ComboDAOImpl();
//
//		List<ComboDTO> listaProveedores = new ArrayList();
//		IComboDAO combosProveedores = new ComboDAOImpl();
//
//		try {
//			listaCategoria = combosCategorias.recuperaCombosCategorias();
//			listaProveedores = combosProveedores.recuperaCombosProveedores();
//
//		} catch (ClassNotFoundException | SQLException | NamingException e) {
//
//			e.printStackTrace();
//		}
//
//		request.setAttribute("comboCategorias", listaCategoria);
//		request.setAttribute("comboProveedores", listaProveedores);
//				
//			}


