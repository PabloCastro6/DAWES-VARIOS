package com.pablo.tienda.controladores.rest;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.tienda.dtos.PeticionesDTO;
import com.pablo.tienda.entities.PeticionEntity;
import com.pablo.tienda.negocio.IPeticionesService;
import com.pablo.tienda.repositories.PeticionesRepository;

@RestController
@RequestMapping("/v1")
public class PeticionesControllerRest {
	
	@Autowired
	IPeticionesService peticionesService;
	
	@Autowired
	PeticionesRepository peticionesRepository;
	
	@GetMapping("/peticiones")
	public Iterable<PeticionEntity> obtenerTodasPeticiones(){
		
		Iterable<PeticionEntity> peticiones = peticionesRepository.findAll();
		
		return peticiones;
	}
	
	@GetMapping("/peticiones/{id}")
	public ResponseEntity<PeticionEntity> obtenerPeticionPorId(@PathVariable("id") Integer id){
		
		PeticionEntity peticion = peticionesRepository.findById(id).get();
		
		return new ResponseEntity(peticion, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/peticiones", params = {"id", "cliente", "producto", "fecha", "cantidad", "estado"})
	public ResponseEntity<PeticionEntity> obtenerPeticionesConFiltros(@RequestParam (value = "id", required = false) Integer id,
																		@RequestParam (value = "cliente", required = false) Integer cliente,
																		@RequestParam (value = "producto", required = false) Integer producto,
																		@RequestParam (value = "fecha", required = false) String fecha,
																		@RequestParam (value = "cantidad", required = false) Integer cantidad,
																		@RequestParam (value = "estado", required = false) Integer estado){
		
		List<PeticionesDTO> listaPeticiones = peticionesRepository.buscarPeticiones(id.toString(), cliente, producto, fecha, cantidad.toString(), estado);
				
		return new ResponseEntity(listaPeticiones, HttpStatus.OK);
		
	}
	
	@PutMapping("/peticiones")
	public ResponseEntity insertarPeticiones(@RequestBody PeticionEntity peticion) throws ClassNotFoundException, SQLException {
		
		peticionesService.insertarPeticiones(peticion.getidCliente().toString(), peticion.getProducto().toString(), peticion.getCantidad().toString(), peticion.getEstado().toString());
		
		return ResponseEntity.ok("Petición insertada correctamente"); 
			
	}
	
	@PatchMapping(value = "/peticiones", params = {"id", "cliente", "producto", "fecha", "cantidad", "estado"})
	public ResponseEntity actualizarPeticiones(@RequestParam (value = "id", required = false) Integer id,
												@RequestParam (value = "cliente", required = false) Integer cliente,
												@RequestParam (value = "producto", required = false) Integer producto,
												@RequestParam (value = "fecha", required = false) String fecha,
												@RequestParam (value = "cantidad", required = false) Integer cantidad,
												@RequestParam (value = "estado", required = false) Integer estado) throws ClassNotFoundException, SQLException, NamingException {
		
		peticionesService.actualizarPeticiones(id.toString(), cliente.toString(), producto.toString(), fecha, cantidad.toString(), estado.toString());
		
		return ResponseEntity.ok("Petición actualizada correctamente"); 
		
	}
	
	@DeleteMapping("/peticiones/{id}")
	public ResponseEntity borrarPeticiones(@PathVariable("id") Integer id) throws ClassNotFoundException, SQLException, NamingException {
		
		peticionesService.borrarPeticiones(id.toString());
		
		return ResponseEntity.ok("Petición borrada correctamente"); 
		
	}

}
