package com.pablo.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.pablo.hospital.dtos.FarmaciaDTO;
import com.pablo.hospital.model.FarmaciaModelo;



public class FarmaciaController {
	
	public List<FarmaciaDTO> buscarFarmacia(Integer ID, String nombre, String descripcion, Integer cantidadDisponible, Float precio) throws ClassNotFoundException, SQLException {
		FarmaciaModelo fm = new FarmaciaModelo();
		return fm.buscaFarmacia( ID,  nombre,  descripcion,  cantidadDisponible,  precio);
	}
	
public Integer insertarFarmacia( String nombre, String descripcion, Integer cantidadDisponible, Float precio) throws ClassNotFoundException, SQLException {
		
	FarmaciaModelo fm = new FarmaciaModelo();
		return fm.insertarFarmacia(nombre,  descripcion,  cantidadDisponible,  precio);
	}
	
	public Integer actualizarFarmacia(Integer ID, String nombre, String descripcion, Integer cantidadDisponible, Float precio) throws ClassNotFoundException, SQLException {
		
		FarmaciaModelo fm = new FarmaciaModelo();
		return fm.actualizarFarmacia(ID,  nombre,  descripcion,  cantidadDisponible,  precio);
	}

}
