package controllers;

import java.sql.SQLException;
import java.util.List;

import dtos.MedicosDTO;
import model.MedicosModelo;

public class MedicosController {
	
	public  List<MedicosDTO>buscarMedico (Integer iD, String nombre, String apellido, String especialidad, String licenciaMedica,
			String telefono, String correoElectronico) throws ClassNotFoundException, SQLException {
		MedicosModelo cm = new MedicosModelo();
		return cm.buscarMedico( iD,  nombre,  apellido,  especialidad,  licenciaMedica,
			 telefono,  correoElectronico);
	}
	
	public Integer insertarMedico (Integer iD, String nombre, String apellido, String especialidad, String licenciaMedica,
			String telefono, String correoElectronico) throws ClassNotFoundException, SQLException {
		MedicosModelo  cm = new MedicosModelo();
		
		return cm.insertarMedico( iD,  nombre,  apellido,  especialidad,  licenciaMedica,
				 telefono,  correoElectronico);
		
	}
	
	public Integer actualizarMedico (Integer iD, String nombre, String apellido, String especialidad, String licenciaMedica,
			String telefono, String correoElectronico) throws ClassNotFoundException, SQLException {
		
		MedicosModelo  cm = new MedicosModelo();
		
		return cm.actualizarMedico( iD,  nombre,  apellido,  especialidad,  licenciaMedica,
				 telefono,  correoElectronico);
		
	}

}
