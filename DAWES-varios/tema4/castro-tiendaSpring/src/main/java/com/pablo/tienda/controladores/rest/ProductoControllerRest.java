package com.pablo.tienda.controladores.rest;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.tienda.dtos.ProductoDTO;
import com.pablo.tienda.entities.ProductoEntity;
import com.pablo.tienda.negocio.IProductosService;
import com.pablo.tienda.repositories.ProductosRepository;

@RestController
@RequestMapping("/v1")
public class ProductoControllerRest {
	

		@Autowired
		IProductosService productosService;
		
		@Autowired
		ProductosRepository productosRepository;
		
		@GetMapping("/productos")
		public Iterable<ProductoEntity> obtenerTodosProductos(){
			
			Iterable<ProductoEntity> productos = productosRepository.findAll();
			
			return productos;
			
		}
		
		@GetMapping ("/productos/{id}")
		public ResponseEntity<ProductoEntity> ObtenerProductosPorId(@PathVariable("id") Integer id){
			
			ProductoEntity productos = productosRepository.findById(id).get();
			
			return new ResponseEntity(productos, HttpStatus.OK);
			
		}

		@GetMapping (value = "/productos", params = {"id", "nombre", "descripcion", "precio", "cantidadEnStock"})
		public ResponseEntity<ProductoEntity> obtenerProductosConFiltros(@RequestParam (value = "id", required = false) Integer id,
																			@RequestParam (value = "nombre", required = false) String nombre,
																			@RequestParam (value = "descripcion", required = false) String descripcion,
																			@RequestParam (value = "precio", required = false) Double precio,
																			@RequestParam (value = "cantidadEnStock", required = false) Integer cantidadEnStock){
			
			List<ProductoDTO> listaProductos = productosRepository.buscarProducto(id.toString(), nombre, descripcion, precio.toString(), cantidadEnStock.toString(), null, null);
			
			return new ResponseEntity(listaProductos, HttpStatus.OK);
			
		}
		
		@PostMapping("/productos")
		public ResponseEntity insertarProducto(@RequestBody ProductoEntity productos) throws ClassNotFoundException, SQLException, NamingException {
			
			productosService.insertarProducto(productos.getNombre(),productos.getDescripcion(),productos.getPrecio().toString(),productos.getCantidadEnStock().toString(), productos.getCategoria().getId().toString(), productos.getProveedorEntity().getId().toString());
			
			return ResponseEntity.ok("Producto insertado correctamente"); 
		}
		
		
		
		
		@PutMapping(value = "/productos", params = {"id", "nombre", "descripcion", "precio", "cantidadEnStock"})
		public ResponseEntity actualizarProducto(@RequestParam (value = "id", required = false) Integer id,
												@RequestParam (value = "nombre", required = false) String nombre,
												@RequestParam (value = "descripcion", required = false) String descripcion,
												@RequestParam (value = "precio", required = false) Double precio,
												@RequestParam (value = "cantidadEnStock", required = false) Integer cantidadEnStock) throws ClassNotFoundException, SQLException, NamingException {
			
			productosService.modificarProducto(id.toString(), nombre, descripcion, precio.toString(), cantidadEnStock.toString(), null, null);
			
			return ResponseEntity.ok("Producto actualizado correctamente");
			
		}
		
	}

