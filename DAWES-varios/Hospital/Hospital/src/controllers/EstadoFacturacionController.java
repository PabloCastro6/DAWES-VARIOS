package controllers;

import java.util.List;

import dtos.EstadoFacturacionDTO;

public class EstadoFacturacionController {
	
public List<EstadoFacturacionDTO> buscarEstadoFacturacion (String iD, String estado) {
	EstadoFacturacionModelo am = new EstadoFacturacionModelo();
	return am.buscarEstadoFacturacion(String iD, String estado);
}

public Integer insertarEstadoFacturacion(String estado) {
	
	EstadoFacturacionModelo am = new EstadoFacturacionModelo();
	return am.buscarEstadoFacturacion(estado);
	
}

publci Integer actualizarEstadoFacturacion(Integer iD, String estado) {
	
	EstadoFacturacionModelo am = new EstadoFacturacionModelo();
	return am.buscarEstadoFacturacion(iD,estado);
	
}
}
