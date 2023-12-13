package com.pablo.tienda.controladores;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pablo.tienda.dtos.CategoriasDTO;
import com.pablo.tienda.negocio.ICategoriasService;


@Controller
@RequestMapping("/categorias/")
public class CategoriasController {
	
	@Autowired
	ICategoriasService categoriasService;
	
	
	@GetMapping("listarcategorias")
	public String getListadoCategorias() {
		return "listadoCategorias";
	}
	
	@PostMapping("listarCategorias")
	public String buscarCategorias(@RequestParam("id_categoria") String id, @RequestParam("nombre") String nombre,
								@RequestParam("descripcion")String descripcion,
								@RequestParam(value="activo", required = false)String activo, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		
		activo = (activo != null)? "1": "0";
		
		
		List<CategoriasDTO> listaCategorias = categoriasService.buscarCategoria(id, nombre, descripcion, activo);
		
		model.addAttribute("lista", listaCategorias);
		
		return "listadoCategorias";
		
	}
	
	
	@PostMapping("insertaralumnos")
	public String insertarAlumno(@RequestParam("id_categoria") String id, @RequestParam("nombre") String nombre,
								@RequestParam("descripcion")String descripcion,
								@RequestParam(value="activo", required = false)String activo,
								ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		
		
		
		activo = (activo != null)? "1": "0";
		
		Integer resultado = categoriasService.insertarCategoria(id, nombre, descripcion, activo);
		model.addAttribute("resultado", resultado);
		
		
		
		
		return "insertarCategorias";
	}
	
	@GetMapping("formularioactualizarcategoria")
	public String getFormularioActualizarCategoria() {
		return "actualizarCategorias";
	}
	
	@PostMapping("formularioactualizarcategoria")
	public String getFormulariosActualizarAlumnos(@RequestParam("id_categoria") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion")String descripcion,
			@RequestParam(value="activo", required = false)String activo, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		
		activo = (activo != null)? "1": "0";
		
		
		
		List<CategoriasDTO> listaCategoria = categoriasService.buscarCategoria(id, nombre, descripcion, activo);		
		model.addAttribute("lista", listaCategoria);
		
		return "actualizarCategorias";
	}
	
	@PostMapping("actualizarcategoria")
	public String actualizarCategoria(@RequestParam("id_categoria") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion")String descripcion,
			@RequestParam(value="activo", required = false)String activo, 
			ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		
		activo = (activo != null)? "1": "0";
		
		categoriasService.modificarCategoria(id, nombre, descripcion, activo);
		
		return "actualizarCategorias";
	}
	
	@GetMapping("formularioborrarcategoria")
		public String formularioBorrarCategoria() {
			
			return "borrarCategorias";
			
		
	}
	
	@PostMapping("formularioborrarcategoria")
	public String getFormulariosBorrarCategorias(@RequestParam("id_categoria") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion")String descripcion, 
			@RequestParam(value="activo", required = false)String activo, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		
		activo = (activo != null)? "1": "0";
		
		
		
		List<CategoriasDTO> listaCategorias = categoriasService.buscarCategoria(id, nombre, descripcion, activo);		
		model.addAttribute("lista", listaCategorias);
		
		return "borrarCategorias";
	}
	
	@PostMapping("borrarcategoria")
	public String borrarCategoria(@RequestParam("id_categoria") String id) throws ClassNotFoundException, SQLException, NamingException {
		categoriasService.borrarCategoria(id);
		
		return "borrarCategoria";
	}

}
