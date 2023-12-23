package com.pablo.tienda.dao.tndimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pablo.tienda.dao.IProductosDAO;
import com.pablo.tienda.dtos.ProductosDTO;
import com.pablo.tienda.utils.DBUtils;

public class ProductosDAOImpITnd implements IProductosDAO{

	private static final Logger logger = LoggerFactory.getLogger(ProductosDAOImpITnd.class) ;
	
	public List<ProductosDTO> obtenerTodosProductos()throws ClassNotFoundException, SQLException, NamingException {
		ResultSet productosResultSet = null;
		List<ProductosDTO> lisaProductos = new ArrayList<ProductosDTO>();
		Connection connection = DBUtils.conectaBBDD();
		
		Statement st = connection.createStatement();
		productosResultSet = st.executeQuery("SELECT * FROM productos");
		
		while(productosResultSet.next()) {
			listaProductos.add(new ProductosDTO());
		}
		
		
		public List<ProductosDTO> buscarProductos() throws ClassNotFoundException, SQLException, NamingException {
			
			String sql = "SELECT p.ID_Producto, p.Nombre, p.Descripcion, p.Precio, p.CantidadEnStock, "
	                + " p.ID_Categoria, p.ID_Proveedor " + " FROM Productos p " + " INNER JOIN Categorias c "
	                + " ON p.ID_Categoria = c.ID_Categoria " + " INNER JOIN Proveedores pr "
	                + " ON p.ID_Proveedor = pr.ID_Proveedor "
	                + " WHERE p.ID_Producto LIKE ? AND p.Nombre LIKE ? AND p.Descripcion LIKE ? AND p.Precio >= ? AND p.CantidadEnStock >= ? "
	                + " AND p.ID_Categoria LIKE ? " + " AND p.ID_Proveedor LIKE ? ";
		}
		
		
		
		public Integer insertarProductos() throws ClassNotFoundException, SQLException, NamingException {
			
		}
			String sql = "INSERT INTO productos (ID_Producto,Nombre,Descripcion,Precio,CantidadEnStock,"
			              + " ID_Categoria,ID_Proveedor " 
						  + "  VALUES (?, ?, ?, ?, ?, ?, ?) ";
		
	}
	
}
