package com.pablo.tienda.controladores.rest;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

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

import com.pablo.tienda.dtos.CategoriasDTO;
import com.pablo.tienda.entities.CategoriasEntity;
import com.pablo.tienda.negocio.ICategoriasService;
import com.pablo.tienda.repositories.CategoriasRepository;

@RestController
@RequestMapping("/v1")
public class CategoriaControllerRest {

	@Autowired
	CategoriasRepository categoriasrepository;

	@Autowired
	ICategoriasService categoriasService;

//	@Autowired
//	CategoriasDTO categoriaDTO;

	@GetMapping("/categorias")
	public Iterable<CategoriasEntity> obtenerTodasCategorias() {
		Iterable<CategoriasEntity> categorias = categoriasrepository.findAll();

		return categorias;
	}

	@GetMapping("/categorias/{id}")
	public ResponseEntity<CategoriasEntity> obtenerCategoriasPorId(@PathVariable("id") Integer id) {

		CategoriasEntity categorias = categoriasrepository.findById(id).get();

		return new ResponseEntity(categorias, HttpStatus.OK);
	}

	@GetMapping(value = "/categorias", params = { /*"id",*/ "nombre", "descripcion", "activo" }) 
	public ResponseEntity obtenerCategoriasConFiltros(
			/*@RequestParam(value = "id", required = false) Integer id,*/
			@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			@RequestParam(value = "activo", required = true) Integer activo) {

		List<CategoriasDTO> listaCategorias = categoriasrepository.buscaCategorias(/*id.toString(),*/ nombre, descripcion,
				activo);

		return new ResponseEntity(listaCategorias, HttpStatus.OK);

	}

	@PostMapping("/categorias")
	public ResponseEntity insertarCategorias(@RequestBody CategoriasEntity categorias)
			throws ClassNotFoundException, SQLException, NamingException {

		categoriasService.insertarCategoria(categorias.getNombre(), categorias.getDescripcion(),
				categorias.getActivo().toString());

		return ResponseEntity.ok("Categoria insertada correctamente");
	}

	@PutMapping(value = "/categorias/{id}")
	public ResponseEntity actualizarCategorias(@PathVariable(value = "id", required = false) Integer id,@RequestBody CategoriasEntity categorias)
			throws ClassNotFoundException, SQLException, NamingException {

		Integer resultado = categoriasService.modificarCategoria(id.toString(),categorias.getNombre(),categorias.getDescripcion(),categorias.getActivo().toString());

		return ResponseEntity.ok("Categoria actualizada correctamente");
	}

	@DeleteMapping("/categorias/{id}")
	public ResponseEntity borrarCategoria(@PathVariable("id") Integer id)
			throws ClassNotFoundException, SQLException, NamingException {

		categoriasService.borrarCategoria(id.toString());

		return ResponseEntity.ok("Categoria borrada correctamente");
	}
}
