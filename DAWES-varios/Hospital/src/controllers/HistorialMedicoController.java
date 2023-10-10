package controllers;

import java.sql.SQLException;
import java.util.List;

import dtos.HistorialMedicoDTO;
import model.HistorialMedicoModelo;

public class HistorialMedicoController {
	
	public List<HistorialMedicoDTO> buscarHistorialMedico (Integer iD, Integer pacienteID, Integer medicoID, String fecha, String diagnostico,
			String tratamiento) throws ClassNotFoundException, SQLException {
		HistorialMedicoModelo hm = new HistorialMedicoModelo();
		return hm.buscaHistorialMedico(iD, pacienteID, medicoID, fecha, diagnostico, tratamiento);
	}
	
	public Integer insertarHistorialPaciente (Integer iD, Integer pacienteID, Integer medicoID, String fecha, String diagnostico,
			String tratamiento) throws ClassNotFoundException, SQLException {
		HistorialMedicoModelo hm = new HistorialMedicoModelo();
		return hm.insertarHistorialMedico(iD, pacienteID, medicoID, fecha, diagnostico, tratamiento);
		
	}
	
	public Integer actualizarHistorialMedico(Integer iD, Integer pacienteID, Integer medicoID, String fecha, String diagnostico,
			String tratamiento) throws ClassNotFoundException, SQLException {
		
		HistorialMedicoModelo hm = new HistorialMedicoModelo();
		return hm.actualizarHistorialMedico(iD, pacienteID, medicoID, fecha, diagnostico, tratamiento);
		
		
	}

}
