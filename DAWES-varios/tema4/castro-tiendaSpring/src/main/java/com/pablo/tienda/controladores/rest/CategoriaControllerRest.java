package com.pablo.tienda.controladores.rest;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.tienda.entities.CategoriasEntity;
import com.pablo.tienda.negocio.impl.CategoriasService;

@RestController
@RequestMapping("/vl")
public class CategoriaControllerRest {
	
	@Autowired
	CategoriasService categoriasServicio;
	@PostMapping("/categorias")
	public ResponseEntity insertarCategorias(@RequestBody CategoriasEntity categoria) throws ClassNotFoundException, SQLException, NamingException {
		
	
		Integer resultado = CategoriasService.insertarCategoria(categoria.getNombre(), categoria.getDescripcion(), categoria.getActivo().toString());
		return new ResponseEntity<>("Categoria insertada correctamente", HttpStatus.OK);
	}

}
