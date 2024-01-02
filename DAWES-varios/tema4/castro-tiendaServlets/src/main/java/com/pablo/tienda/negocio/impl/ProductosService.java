package com.pablo.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dao.tndimpl.CategoriasDAOImplTnd;
import com.pablo.tienda.dao.tndimpl.ProductosDAOImplTnd;
import com.pablo.tienda.dtos.CategoriasDTO;
import com.pablo.tienda.dtos.ProductosDTO;
import com.pablo.tienda.negocio.ICategoriasService;
import com.pablo.tienda.negocio.IProductosService;


public class ProductosService implements IProductosService {   
	
	

	@Override
	public List<ProductosDTO> buscarProducto(String id, String nombre, String descripcion, String precio,
			String CantidadStock,String idCategoria, String idProveedor)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return new ProductosDAOImplTnd().buscarProductos(id, nombre, descripcion,precio,CantidadStock,idCategoria,idProveedor);
	}

	@Override
	public Integer insertarProducto( String nombre, String descripcion, String precio,
			String CantidadStock,String idCategoria, String idProveedor)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return new ProductosDAOImplTnd().insertarProducto( nombre, descripcion,precio,CantidadStock,idCategoria,idProveedor);
	}

	@Override
	public Integer modificarProducto(String id, String nombre, String descripcion, String precio,
			String CantidadStock,String idCategoria, String idProveedor)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return new ProductosDAOImplTnd().actualizarProducto(id, nombre, descripcion,precio,CantidadStock,idCategoria,idProveedor );
	}

}
