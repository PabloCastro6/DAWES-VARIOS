package com.pablo.tienda.dao.tndimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pablo.tienda.dao.IProductosDAO;
import com.pablo.tienda.dtos.ProductosDTO;
import com.pablo.tienda.utils.DBUtils;

public class ProductosDAOImplTnd implements IProductosDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProductosDAOImplTnd.class);



	@Override
	public List<ProductosDTO> buscarProductos(String id, String nombre, String descripcion, String precio,
			String CantidadStock, String idCategoria, String idProveedor) throws ClassNotFoundException, SQLException, NamingException {

		String sql = "SELECT p.ID_Producto, p.Nombre, p.Descripcion, p.Precio, p.CantidadEnStock,"
				+ " c.Nombre , pv.Nombre " + " FROM productos p "
				+ " INNER JOIN categorias c ON p.ID_Categoria = c.ID_Categoria "
				+ " INNER JOIN proveedores pv ON p.ID_Proveedor = pv.ID_Proveedor "
				+ " WHERE p.ID_Producto = ? AND p.Nombre LIKE ? AND p.Descripcion LIKE ? AND  p.Precio>=? "
				+ " AND  p.CantidadEnStock >=? AND c.ID_Categoria = ? AND pv.ID_Proveedor = ?;";

		Connection connection = DBUtils.conectaBBDD();
		List<ProductosDTO> listaProductos = new ArrayList<>();

		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, id );
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + descripcion + "%");
		ps.setString(4, precio);
		ps.setString(5, CantidadStock);
		ps.setString(6,  idCategoria);
		ps.setString(7, idProveedor);

		System.out.println(ps.toString());
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			listaProductos.add(new ProductosDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
					rs.getInt(5),rs.getString(6),rs.getString(7)));
		}
		connection.close();
		return listaProductos;

	}

	@Override
	public Integer insertarProducto( String nombre, String descripcion, String precio,
			String cantidadStock,String idCategoria, String idProveedor)
			throws ClassNotFoundException, SQLException, NamingException {

		String sql = "INSERT INTO productos (Nombre,Descripcion,Precio,CantidadEnStock,"
				+ " ID_Categoria,ID_Proveedor) VALUES (?, ?, ?, ?, ?, ?) ";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		
		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setString(3, precio);
		ps.setString(4, cantidadStock);
		ps.setString(5, idCategoria);
		ps.setString(6, idProveedor);

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public Integer actualizarProducto(String id, String nombre, String descripcion, String precio,
			String cantidadStock,String idCategoria, String idProveedor)
			throws ClassNotFoundException, SQLException, NamingException {

		String sql = " UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, cantidadEnStock = ?, ID_categoria = ?, ID_proveedor = ? "
				+ " WHERE ID_producto = ? ";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setString(3, precio);
		ps.setString(4, cantidadStock);
		ps.setString(5, idCategoria);
		ps.setString(6, idProveedor);
		ps.setString(7, id);

		Integer resultado = ps.executeUpdate();
		ps.toString();
		connection.close();
		return resultado;
	}

	
}
	

