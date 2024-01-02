package com.pablo.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.ProductosDTO;

public interface IProductosDAO {
	

	
	public List<ProductosDTO> buscarProductos(String id, String nombre, String descripcion, String precio,
			String CantidadStock,String idCategoria, String idProveedor)throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarProducto(String nombre, String descripcion, String precio,
			String CantidadStock,String idCategoria, String idProveedor)throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer actualizarProducto(String id, String nombre, String descripcion, String precio,
			String CantidadStock,String idCategoria, String idProveedor)throws ClassNotFoundException, SQLException, NamingException;

	
}



