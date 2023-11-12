package com.pablo.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.pablo.hospital.dtos.HabitacionesDTO;
import com.pablo.hospital.model.HabitacionesModelo;

public class HabitacionesController {

	public List<HabitacionesDTO> buscarHabitacion(String iD, String tipo, String estado, Float costoPorDia)
			throws ClassNotFoundException, SQLException {

		HabitacionesModelo hm = new HabitacionesModelo();
		return hm.buscarHabitacion(iD, tipo, estado, costoPorDia);

	}

	public Integer insertarHabitacion(String tipo, String estado, Float costoPorDia)
			throws ClassNotFoundException, SQLException {
		HabitacionesModelo hm = new HabitacionesModelo();
		return hm.insertarHabitaciones(tipo, estado, costoPorDia);
	}

	public Integer actualizarHabitacion(String iD, String tipo, String estado, Float costoPorDia)
			throws ClassNotFoundException, SQLException {
		HabitacionesModelo hm = new HabitacionesModelo();
		return hm.actualizarHabitacion(iD, tipo, estado, costoPorDia);
	}

}
