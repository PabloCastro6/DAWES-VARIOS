package com.pablo.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.ProveedorDTO;

public interface IProveedorDAO {
	
public  List<ProveedorDTO> buscarProveedores(String id , String nombre, String contacto, String telefono, String correo, String direccion, String activo)throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer insertarProveedores(String nombre, String contacto, String telefono, String correo, String direccion, String activo)throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer actualizarProveedores(String id , String nombre, String contacto, String telefono, String correo, String direccion, String activo)throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer borrarProveedores(String id )throws ClassNotFoundException, SQLException, NamingException;

	
}
