package com.pablo.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.pablo.hospital.dtos.CitasDTO;
import com.pablo.hospital.model.CitasModelo;


public class CitasController {
	
    public List<CitasDTO> buscarCita(String id, String pacienteID, String medicoID, String fecha, String hora, String estadoID)
            throws ClassNotFoundException, SQLException {
        CitasModelo cm = new CitasModelo();
        return cm.buscaCita(id, pacienteID, medicoID, fecha, hora, estadoID);
    }

    public Integer insertarCita( String pacienteID, String medicoID, String fecha, String hora, String estadoID) throws ClassNotFoundException, SQLException {
        CitasModelo cm = new CitasModelo();
        return cm.insertarCita ( pacienteID, medicoID, fecha, hora, estadoID);
    }

    public Integer actualizarCita(Integer iD, String pacienteID, String medicoID, String fecha, String hora, String estadoID)
            throws ClassNotFoundException, SQLException {
        CitasModelo cm = new CitasModelo();
        return cm.actualizarCita(iD, pacienteID, medicoID, fecha, hora, estadoID);
    }
}