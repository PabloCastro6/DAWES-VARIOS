package controllers;

import java.sql.SQLException;
import java.util.List;

import dtos.AlergiaDTO;
import model.AlergiasModelo;

public class AlergiasController {
	public List<AlergiaDTO> buscarAlergias(String id, String nombre) throws ClassNotFoundException, SQLException{
		AlergiasModelo am = new AlergiasModelo();
		return am.buscaAlergia(id, nombre);
	}
	
	
	public Integer insertarAlergia(String nombreAlergia) throws ClassNotFoundException, SQLException {
		
		AlergiasModelo cm = new AlergiasModelo();
		return cm.insertarAlergia(nombreAlergia);
	}
	
	public Integer actualizarAlergia(Integer id, String nombreAlergia) throws ClassNotFoundException, SQLException {
		
		AlergiasModelo cm = new AlergiasModelo();
		return cm.actualizarAlergia(id, nombreAlergia);
	}
	
	
}

