package com.pablo.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.pablo.hospital.dtos.FacturacionDTO;
import com.pablo.hospital.model.FacturacionModelo;



public class FacturacionController {

		public List<FacturacionDTO> buscarfacturacion(Integer id, Integer pacienteID, String fecha, Float monto, Integer estadoID)  throws ClassNotFoundException, SQLException {
			FacturacionModelo cm = new FacturacionModelo();
			return cm.buscarFacturacion( id,  pacienteID,  fecha,  monto, estadoID);
		}
		
		public Integer insertarFacturacion (  String fecha, Float monto) throws ClassNotFoundException, SQLException {
			FacturacionModelo cm = new FacturacionModelo();
			return cm.insertarFacturacion(  fecha,  monto);
		}
		
		public Integer actualizarFacturacion( Integer id, Integer pacienteID, String fecha, Float monto, Integer estadoID) throws ClassNotFoundException, SQLException {
			
			FacturacionModelo cm = new FacturacionModelo();
			return cm.actualizarFacturacion( id,  pacienteID,  fecha,  monto, estadoID);
		}
		
		
	}

	
