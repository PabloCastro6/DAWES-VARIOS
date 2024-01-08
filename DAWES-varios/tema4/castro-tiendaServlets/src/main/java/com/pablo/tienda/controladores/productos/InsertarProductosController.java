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

import com.pablo.tienda.dao.ICategoriasDAO;
import com.pablo.tienda.dao.IProveedorDAO;
import com.pablo.tienda.dao.tndimpl.CategoriasDAOImplTnd;
import com.pablo.tienda.dao.tndimpl.ProveedorDAOImplTnd;
import com.pablo.tienda.dtos.CategoriasDTO;
import com.pablo.tienda.dtos.ProveedorDTO;
import com.pablo.tienda.negocio.impl.CategoriasService;
import com.pablo.tienda.negocio.impl.ProductosService;



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
		
		
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/productos/insertarProductos.jsp");
		d.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer resultado = 0;
		
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
        String precio = request.getParameter("precio");
        String cantidadStock = request.getParameter("cantidadStock");
        String idCategoria = request.getParameter("idCategoria");
        String idProveedor = request.getParameter("idProveedor");
		
		try {
			resultado = new ProductosService().insertarProducto(nombre, descripcion, precio,cantidadStock,idCategoria,idProveedor);
			
					} catch (ClassNotFoundException | SQLException | NamingException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("resultado", resultado);
		
		doGet(request, response);
	 }
	
	
//	//RECUPERACION DE COMBOS
//
//			List<CategoriasDTO> listaCategorias = new ArrayList<CategoriasDTO>();
//			ICategoriasDAO comboCategoria = new CategoriasDAOImplTnd();
//			
//			List<ProveedorDTO> listaProveedores = new ArrayList<ProveedorDTO>();
//			IProveedorDAO comboProveedores = new ProveedorDAOImplTnd();
//			
//			try {
//				listaCategorias = comboCategoria.RecuperarCategoria();
//				listaProveedores = comboProveedores.RecuperarProveedor();
//
//			} catch (ClassNotFoundException | SQLException | NamingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//			
//
//			request.setAttribute("comboCategoria", listaCategorias);
//			System.out.println("1");
//			request.setAttribute("comboProveedores", listaProveedores);
//			System.out.println("2");
//			RequestDispatcher d = getServletContext()
//					.getRequestDispatcher("/WEB-INF/vistas/productos/listadoProductos.jsp");
//			d.forward(request, response);
//		}
		
		

	}

