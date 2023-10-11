package com.pablo.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.pablo.hospital.dtos.FarmaciaDTO;
import com.pablo.hospital.model.FarmaciaModelo;



public class FarmaciaController {
	
	public List<FarmaciaDTO> buscarFarmacia(Integer medicamento, String nombre, String descripcion, Integer cantidadDisponible, Float precio) throws ClassNotFoundException, SQLException {
		FarmaciaModelo fm = new FarmaciaModelo();
		return fm.buscaFarmacia( medicamento,  nombre,  descripcion,  cantidadDisponible,  precio);
	}
	
public Integer insertarFarmacia(Integer medicamento, String nombre, String descripcion, Integer cantidadDisponible, Float precio) throws ClassNotFoundException, SQLException {
		
	FarmaciaModelo fm = new FarmaciaModelo();
		return fm.insertarFarmacia(medicamento,  nombre,  descripcion,  cantidadDisponible,  precio);
	}
	
	public Integer actualizarFarmacia(Integer medicamento, String nombre, String descripcion, Integer cantidadDisponible, Float precio) throws ClassNotFoundException, SQLException {
		
		FarmaciaModelo fm = new FarmaciaModelo();
		return fm.actualizarFarmacia(medicamento,  nombre,  descripcion,  cantidadDisponible,  precio);
	}

}
