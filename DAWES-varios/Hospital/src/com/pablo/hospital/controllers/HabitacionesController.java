//package com.pablo.hospital.controllers;
//
//import java.util.List;
//
//import com.pablo.hospital.dtos.HabitacionesDTO;
//import com.pablo.hospital.model.HabitacionesModelo;
//
//
//public class HabitacionesController {
//	
//	public List<HabitacionesDTO> buscarHabitacion (Integer iD, String tipo, String estado, Float costoPorDia) {
//		
//		HabitacionesModelo hm = new HabitacionesModelo();
//		return hm.buscarHistoria( iD,  tipo,  estado,  costoPorDia);
//		
//	}
//	
//	public Integer insertarHabitacion (Integer iD, String tipo, String estado, Float costoPorDia) {
//		HabitacionesModelo hm = new HabitacionesModelo();
//		return hm.insertarHabitacion( iD,  tipo,  estado,  costoPorDia);
//	}
//	
//	public Integer actualizarHabitacion (Integer iD, String tipo, String estado, Float costoPorDia) {
//		HabitacionesModelo hm = new HabitacionesModelo();
//		return hm.actualizarHabitacion( iD,  tipo,  estado,  costoPorDia);
//	}
//
//}
