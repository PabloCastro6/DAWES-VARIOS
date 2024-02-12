package com.pablo.tienda.springdatajpaimpl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IProveedorDAO;
import com.pablo.tienda.dtos.ProveedorDTO;
import com.pablo.tienda.repositories.ProveedoresRepository;

@Component("ProveedoresDAOImplSpringDataJPA")
public class ProveedoresDAOImplSpringDataJPA implements IProveedorDAO {

	@Autowired
	private ProveedoresRepository proveedorRepository;

	@Override
	public List<ProveedorDTO> buscarProveedores(String id, String nombre, String contacto, String telefono,
			String correo, String direccion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return proveedorRepository.buscaProveedor(Integer.parseInt(id),nombre, contacto,telefono,correo,direccion, Integer.parseInt(activo));
	}

	@Override
	public Integer insertarProveedores(String nombre, String contacto, String telefono, String correo, String direccion,
			String activo) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer actualizarProveedores(String id, String nombre, String contacto, String telefono, String correo,
			String direccion, String activo) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarProveedores(String id) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

}
