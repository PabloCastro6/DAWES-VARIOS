package com.pablo.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.pablo.hospital.dtos.EstadoCitasDTO;
import com.pablo.hospital.model.EstadoCitasModelo;


public class EstadoCitasController {
	
	public List<EstadoCitasDTO> buscarEstadoCitas(String id, String estado) throws ClassNotFoundException, SQLException {
		EstadoCitasModelo cm = new EstadoCitasModelo();
		return cm.buscarEstadoCitas(id, estado);
	}
	
	public Integer insertarEstadoCitas(String id, String estado) throws ClassNotFoundException, SQLException {
		EstadoCitasModelo cm = new EstadoCitasModelo();
		return cm.insertarEstadoCitas(id, estado);
	}
	
	public Integer actualizarEstadoCitas(String id, String estado) throws ClassNotFoundException, SQLException {
		EstadoCitasModelo cm = new EstadoCitasModelo();
		return cm.actualizarEstadoCitas(id, estado);
		
	}

}
