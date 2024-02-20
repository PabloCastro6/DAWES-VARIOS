package com.pablo.tienda.controladores.rest;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.tienda.dtos.ClienteDTO;
import com.pablo.tienda.entities.ClientesEntity;
import com.pablo.tienda.negocio.IClientesService;
import com.pablo.tienda.repositories.ClientesRepository;

@RestController
@RequestMapping("/v1")
public class ClientesControllerRest {
	
	@Autowired
	IClientesService clientesService;
	
	@Autowired
	ClientesRepository clientesRepository;
	
	@GetMapping("/clientes")
	public Iterable<ClientesEntity> obtenerTodosClientes(){
		
		Iterable<ClientesEntity> clientes = clientesRepository.findAll();
		
		return clientes;
		
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<ClientesEntity> obtenerClientePorId(@PathVariable("id") Integer id){
		
		ClientesEntity cliente = clientesRepository.findById(id).get();
		
		return new ResponseEntity(cliente, HttpStatus.OK);
	}
	
	@GetMapping(value = "/clientes", params = {"id", "nombre", "correoElectronico", "password", "fechaRegistro", "poblacion", "activo"})
	public ResponseEntity<ClientesEntity> obtenerClientesConFiltros(@RequestParam (value = "id", required = false) Integer id,
																	@RequestParam (value = "nombre", required = false) String nombre,
																	@RequestParam (value = "correoElectronico", required = false) String correoElectronico,
																	@RequestParam (value = "poblacion", required = false) Integer poblacion,
																	@RequestParam (value = "activo", required = false) Integer activo){
		
		List<ClienteDTO> listaClientes = clientesRepository.buscarCliente(id.toString(), nombre, correoElectronico, poblacion, activo);
		
		return new ResponseEntity(listaClientes, HttpStatus.OK);
		
	}
	
	@PostMapping("/clientes")
	public ResponseEntity insertarCliente(@RequestBody ClientesEntity cliente) throws ClassNotFoundException, SQLException {
		
		clientesService.insertarClientes(cliente.getNombre(), cliente.getCorreoElectronico(), cliente.getPoblacion().getId().toString(), cliente.getActivo().toString());
		
		return ResponseEntity.ok("Cliente insertado correctamente");
	}
	
	@PutMapping(value = "/clientes", params = {"id", "nombre", "correoElectronico", "poblacion", "activo"})
	public ResponseEntity actualizarCliente(@RequestParam (value = "id", required = false) Integer id,
											@RequestParam (value = "nombre", required = false) String nombre,
											@RequestParam (value = "correoElectronico", required = false) String correoElectronico,
											@RequestParam (value = "poblacion", required = false) Integer poblacion,
											@RequestParam (value = "activo", required = false) Integer activo) throws ClassNotFoundException, SQLException {
		
		clientesService.modificarClientes(id.toString(), nombre, correoElectronico, poblacion.toString(), activo.toString());
		
		return ResponseEntity.ok("Cliente actualizado correctamente");
		
	}
	
	@DeleteMapping ("/clientes/{id}")
	public ResponseEntity borrarCliente (@PathVariable("id") Integer id) throws ClassNotFoundException, SQLException {
		
		clientesService.borrarClientes(id.toString());
		
		return ResponseEntity.ok("Cliente borrado correctamente");
	}
}


