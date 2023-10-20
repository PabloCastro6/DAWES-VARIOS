package com.pablo.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.pablo.hospital.dtos.EstadoFacturacionDTO;
import com.pablo.hospital.model.EstadoFacturacionModelo;

public class EstadoFacturacionController {

	public List<EstadoFacturacionDTO> buscarEstadoFacturacion(String iD, String estado)
			throws ClassNotFoundException, SQLException {
		EstadoFacturacionModelo am = new EstadoFacturacionModelo();
		return am.buscarEstadoFacturacion(iD, estado);
	}

	public Integer insertarEstadoFacturacion( String estado) throws ClassNotFoundException, SQLException {
		EstadoFacturacionModelo am = new EstadoFacturacionModelo();
		return am.insertarEstadoFacturacion(estado);

	}

	public Integer actualizarEstadoFacturacion(String iD, String estado) throws ClassNotFoundException, SQLException {
		EstadoFacturacionModelo am = new EstadoFacturacionModelo();
		return am.actualizarEstadoFacturacion(iD, estado);

	}
}