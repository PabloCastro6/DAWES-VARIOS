package com.pablo.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.ProductosDTO;

public interface IProductosService {
	

	
	public List<ProductosDTO> buscarProducto(String id, String nombre, String descripcion, String precio,
			String CantidadStock,String idCategoria, String idProveedor) throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarProducto(String nombre, String descripcion, String precio,
			String CantidadStock,String idCategoria, String idProveedor)throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer modificarProducto(String id, String nombre, String descripcion, String precio,
			String CantidadStock,String idCategoria, String idProveedor)throws ClassNotFoundException, SQLException, NamingException;

}
