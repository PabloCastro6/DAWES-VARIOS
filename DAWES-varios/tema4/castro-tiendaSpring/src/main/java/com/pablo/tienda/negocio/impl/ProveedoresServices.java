package com.pablo.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.ICategoriasDAO;
import com.pablo.tienda.dao.IProveedorDAO;
import com.pablo.tienda.dtos.ProveedorDTO;
import com.pablo.tienda.negocio.IProveedoresService;

@Component
public class ProveedoresServices implements IProveedoresService {

//	@Autowired
//	@Qualifier("HibernateImplProveedor")
//	IProveedorDAO proveedorDAO;

	@Autowired
	@Qualifier("ProveedoresDAOImplSpringDataJPA")
	IProveedorDAO proveedorDAO;

	@Override
	public List<ProveedorDTO> buscarProveedores(String id, String nombre, String contacto, String telefono,
			String correo, String direccion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {

		return proveedorDAO.buscarProveedores(id, nombre, contacto, telefono, correo, direccion, activo);
	}

	@Override
	public Integer insertarProveedores(String nombre, String contacto, String telefono, String correo, String direccion,
			String activo) throws ClassNotFoundException, SQLException, NamingException {
		return proveedorDAO.insertarProveedores(nombre, contacto, telefono, correo, direccion, activo);
	}

	@Override
	public Integer actualizarProveedores(String id, String nombre, String contacto, String telefono, String correo,
			String direccion, String activo) throws ClassNotFoundException, SQLException, NamingException {
		return proveedorDAO.actualizarProveedores(id, nombre, contacto, telefono, correo, direccion, activo);
	}

	@Override
	public Integer borrarProveedores(String id) throws ClassNotFoundException, SQLException, NamingException {
		return proveedorDAO.borrarProveedores(id);
	}

}
