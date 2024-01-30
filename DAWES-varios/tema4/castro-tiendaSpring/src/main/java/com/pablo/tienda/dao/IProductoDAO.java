package com.pablo.tienda.dao;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

import com.pablo.tienda.dtos.ProductoDTO;

public interface IProductoDAO {

	public List<ProductoDTO> buscarProducto(String id, String nombre, String descripcion, String precio,
			String cantidadStock, String idCategoria, String idProveedor)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarProducto(String nombre, String descripcion, String precio, String cantidadStock,
			String idCategoria, String idProveedor) throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarProducto(String id, String nombre, String descripcion, String precio, String cantidadStock,
			String idCategoria, String idProveedor) throws ClassNotFoundException, SQLException, NamingException;
	
	public ProductoDTO buscarProductoPorID(Integer id)
			throws ClassNotFoundException, SQLException, NamingException;

}
