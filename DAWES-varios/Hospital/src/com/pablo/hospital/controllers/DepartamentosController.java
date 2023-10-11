package com.pablo.hospital.controllers;

import java.sql.SQLException;
import java.util.List;



public class DepartamentosController {
	public List<DepartamentoDTO> buscarDepartamento(String id, String nombre, String descripcion,String activo)  throws ClassNotFoundException, SQLException {
		DepartamentoModelo cm = new DepartamentoModelo();
		return cm.buscarDepartamento( id,  nombre,  descripcion, activo);
	}
	
	public Integer insertarDepartamento ( String nombre, String descripcion,String activo) throws ClassNotFoundException, SQLException {
		DepartamentoModelo cm = new DepartamentoModelo();
		return cm.insertarDepartamento(  nombre,  descripcion, activo);
	}
	
	public Integer actualizarDepartamento( String id, String nombre, String descripcion,String activo) throws ClassNotFoundException, SQLException {
		
		DepartamentoModelo pm = new DepartamentoModelo();
		return pm.actualizarDepartamento(id,  nombre,  descripcion, activo);
	}
	
public Integer borrarDepartamento(String id) throws ClassNotFoundException, SQLException {
		
		DepartamentoModelo pm = new DepartamentoModelo();
		return pm.borrarDepartamento(id);
	
}

}
