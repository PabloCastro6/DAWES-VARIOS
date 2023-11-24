package com.pablo.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.pablo.hospital.dtos.MedicoDTO;
import com.pablo.hospital.model.MedicosModelo;


public class MedicosController {
	
	public  List<MedicoDTO>buscarMedico (String iD, String nombre, String apellido, String especialidad, String licenciaMedica,
			String telefono, String correoElectronico) throws ClassNotFoundException, SQLException {
		MedicosModelo cm = new MedicosModelo();
		return cm.buscarMedico( iD,  nombre,  apellido,  especialidad,  licenciaMedica,
			 telefono,  correoElectronico);
	}
	
	public Integer insertarMedico ( String nombre, String apellido, String especialidad, String licenciaMedica,
			String telefono, String correoElectronico) throws ClassNotFoundException, SQLException {
		MedicosModelo  cm = new MedicosModelo();
		
		return cm.insertarMedico( nombre,  apellido,  especialidad,  licenciaMedica,
				 telefono,  correoElectronico);
		
	}
	
	public Integer actualizarMedico (String iD, String nombre, String apellido, String especialidad, String licenciaMedica,
			String telefono, String correoElectronico) throws ClassNotFoundException, SQLException {
		
		MedicosModelo  cm = new MedicosModelo();
		
		return cm.actualizarMedico( iD, nombre,  apellido,  especialidad,  licenciaMedica,
				 telefono,  correoElectronico);
		
	}

}