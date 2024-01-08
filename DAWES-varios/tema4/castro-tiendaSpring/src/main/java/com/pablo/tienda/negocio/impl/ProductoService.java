package com.pablo.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IProductoDAO;
import com.pablo.tienda.dtos.ProductoDTO;
import com.pablo.tienda.negocio.IProductosService;


@Component
public class ProductoService implements IProductosService {
	
	@Autowired
	IProductoDAO productoDAO;

	
	public List<ProductoDTO> buscarProducto(String id, String nombre, String descripcion, String precio,
			String CantidadStock,String idCategoria, String idProveedor)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return  productoDAO.buscarProducto(id, nombre, descripcion,precio,CantidadStock,idCategoria,idProveedor);
	}

	
	public Integer insertarProducto( String nombre, String descripcion, String precio,
			String CantidadStock,String idCategoria, String idProveedor)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return  productoDAO.insertarProducto( nombre, descripcion,precio,CantidadStock,idCategoria,idProveedor);
	}

	
	public Integer modificarProducto(String id, String nombre, String descripcion, String precio,
			String CantidadStock,String idCategoria, String idProveedor)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return  productoDAO.actualizarProducto(id, nombre, descripcion,precio,CantidadStock,idCategoria,idProveedor );
	}

}

