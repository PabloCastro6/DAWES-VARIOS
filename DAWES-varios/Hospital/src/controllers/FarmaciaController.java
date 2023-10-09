//package controllers;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import dtos.FarmaciaDTO;
//import model.AlergiasModelo;
//import model.FarmaciaModelo;
//
//public class FarmaciaController {
//	
//	public List<FarmaciaDTO> buscarFarmacia(String medicamento, String nombre, String descripcion, String cantidadDisponible, String precio) throws ClassNotFoundException, SQLException {
//		FarmaciaModelo fm = new FarmaciaModelo();
//		return fm.buscaFarmacia( medicamento,  nombre,  descripcion,  cantidadDisponible,  precio);
//	}
//	
//public Integer insertarFarmacia(String medicamento, String nombre, String descripcion, String cantidadDisponible, String precio) throws ClassNotFoundException, SQLException {
//		
//	FarmaciaModelo fm = new FarmaciaModelo();
//		return fm.insertarFarmacia(medicamento,  nombre,  descripcion,  cantidadDisponible,  precio);
//	}
//	
//	public Integer actualizarFarmacia(Integer medicamento, String nombre, String descripcion, Integer cantidadDisponible, Float precio) throws ClassNotFoundException, SQLException {
//		
//		FarmaciaModelo fm = new FarmaciaModelo();
//		return fm.actualizarFarmacia(medicamento,  nombre,  descripcion,  cantidadDisponible,  precio);
//	}
//
//}
