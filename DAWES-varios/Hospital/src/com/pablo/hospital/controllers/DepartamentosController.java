package com.pablo.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.pablo.hospital.dtos.DepartamentoDTO;
import com.pablo.hospital.model.DepartamentosModelo;

public class DepartamentosController {
	public List<DepartamentoDTO> buscarDepartamento(String iD, String nombre, String descripcion, Integer activo)
			throws ClassNotFoundException, SQLException {
		DepartamentosModelo cm = new DepartamentosModelo();
		return cm.buscarDepartamento(iD, nombre, descripcion, activo);
	}

	public Integer insertarDepartamento(String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException {
		DepartamentosModelo cm = new DepartamentosModelo();
		return cm.insertarDepartamento(nombre, descripcion, activo);
	}

	public Integer actualizarDepartamento(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException {

		DepartamentosModelo pm = new DepartamentosModelo();
		return pm.actualizarDepartamento(id, nombre, descripcion, activo);
	}

	public Integer borrarDepartamento(String id) throws ClassNotFoundException, SQLException {

		DepartamentosModelo pm = new DepartamentosModelo();
		return pm.borrarDepartamento(id);

	}

}
