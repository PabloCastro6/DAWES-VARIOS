package controllers;

import java.sql.SQLException;
import java.util.List;

import dtos.CitasDTO;
import model.AlergiasModelo;
import model.CitasModelo;

public class CitasController {
public List<CitasDTO>buscarCita(Integer citaID, Integer pacienteID, Integer medicoID, Integer fecha, String hora, String estado) {
	CitasModelo cm = new CitasModelo();
	return cm.buscarCita( citaID,  pacienteID,  medicoID,  fecha,  hora,  estado);
}

public Integer insertarCita (Integer citaID, Integer pacienteID, Integer medicoID, Integer fecha, String hora, String estado) {
	CitasModelo cm = new CitasModelo();
	return cm.insertarCita( citaID,  pacienteID,  medicoID,  fecha,  hora,  estado);
}
public Integer actualizarCita(Integer citaID, Integer pacienteID, Integer medicoID, Integer fecha, String hora, String estado) throws ClassNotFoundException, SQLException {
	
	CitasModelo cm = new CitasModelo();
	return cm.actualizarCita(citaID,  pacienteID,  medicoID,  fecha,  hora,  estado);
}

public Integer borrarCliente(Integer citaID, Integer pacienteID, Integer medicoID, Integer fecha, String hora, String estado) throws ClassNotFoundException, SQLException {
	
	CitasModelo cm = new CitasModelo();
	return cm.borrarCliente(citaID,  pacienteID,  medicoID,  fecha,  hora,  estado);
}

}
