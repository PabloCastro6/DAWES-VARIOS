package controllers;

import java.sql.SQLException;
import java.util.List;

import dtos.CitasDTO;
import model.AlergiasModelo;
import model.CitasModelo;

public class CitasController {
public List<CitasDTO>buscarCita(Integer iD, String pacienteID, String medicoID, String fecha, String hora, String estado) {
	CitasModelo cm = new CitasModelo();
	return cm.buscarCita( iD,  pacienteID,  medicoID,  fecha,  hora,  estado);
}

public Integer insertarCita (Integer iD, String pacienteID, String medicoID, String fecha, String hora, String estado) {
	CitasModelo cm = new CitasModelo();
	return cm.insertarCita( iD,  pacienteID,  medicoID,  fecha,  hora,  estado);
}
public Integer actualizarCita(Integer iD, String pacienteID, String medicoID, String fecha, String hora, String estado) throws ClassNotFoundException, SQLException {
	
	CitasModelo cm = new CitasModelo();
	return cm.actualizarCita(iD,  pacienteID,  medicoID,  fecha,  hora,  estado);
}

public Integer borrarCliente(Integer iD, String pacienteID, String medicoID, String fecha, String hora, String estado) throws ClassNotFoundException, SQLException {
	
	CitasModelo cm = new CitasModelo();
	return cm.borrarCliente(iD,  pacienteID,  medicoID,  fecha,  hora,  estado);
}

}
