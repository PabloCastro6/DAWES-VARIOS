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
import org.springframework.web.bind.annotation.PostMapping;
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
	public Iterable<PeticionEntity> obtenerTodasPeticiones() {

		Iterable<PeticionEntity> peticiones = peticionesRepository.findAll();

		return peticiones;
	}

	@GetMapping("/peticiones/{id}")
	public ResponseEntity<PeticionEntity> obtenerPeticionPorId(@PathVariable("id") Integer id) {

		PeticionEntity peticion = peticionesRepository.findById(id).get();

		return new ResponseEntity(peticion, HttpStatus.OK);

	}

	@GetMapping(value = "/peticiones", params = { "id", "cliente", "producto", "fecha", "cantidad", "estado" })
	public ResponseEntity obtenerPeticionesConFiltros(
			@RequestParam(value = "id", required = true) Integer id,
			@RequestParam(value = "cliente", required = true) Integer cliente,
			@RequestParam(value = "producto", required = true) Integer producto,
			@RequestParam(value = "fecha", required = true) String fecha,
			@RequestParam(value = "cantidad", required = true) Integer cantidad,
			@RequestParam(value = "estado", required = true) Integer estado) {

		List<PeticionesDTO> listaPeticiones = peticionesRepository.buscarPorFiltros(id.toString(), cliente.toString(),
				producto.toString(), fecha, cantidad.toString(), estado.toString());

		return new ResponseEntity(listaPeticiones, HttpStatus.OK);

	}

	@PostMapping("/peticiones")
	public ResponseEntity insertarPeticiones(@RequestBody PeticionEntity peticion)
			throws ClassNotFoundException, SQLException, NamingException {

		peticionesService.insertarPeticiones(null,
				null, peticion.getCantidad().toString(), peticion.getEstado().toString());

		return ResponseEntity.ok("Petición insertada correctamente");

	}

	@PutMapping(value = "/peticiones/{id}")
	public ResponseEntity actualizarPeticiones(@PathVariable("id") Integer id, @RequestBody PeticionEntity peticion)
			throws ClassNotFoundException, SQLException, NamingException {

		peticionesService.actualizarPeticiones(id.toString(),null,
				null,peticion.getFecha(), peticion.getCantidad().toString(), peticion.getEstado().toString());

		return ResponseEntity.ok("Petición actualizada correctamente");

	}

	@DeleteMapping("/peticiones/{id}")
	public ResponseEntity borrarPeticiones(@PathVariable("id") Integer id)
			throws ClassNotFoundException, SQLException, NamingException {

		peticionesService.borrarPeticiones(id.toString());

		return ResponseEntity.ok("Petición cancelada correctamente");

	}

}
