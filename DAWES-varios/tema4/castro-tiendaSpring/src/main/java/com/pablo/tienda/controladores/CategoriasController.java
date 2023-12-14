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

	@PostMapping("listarcategorias")
	public String buscarCategorias(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<CategoriasDTO> listaCategorias = categoriasService.buscarCategoria(id, nombre, descripcion, activo);

		model.addAttribute("lista", listaCategorias);

		return "listadoCategorias";

	}

	
	@GetMapping("insertarcategorias")
	public String getInsertarCategorias() {
		return "insertarCategorias";
	}
	
	@PostMapping("insertarcategorias")
	public String insertarCategoria(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		Integer resultado = categoriasService.insertarCategoria( nombre, descripcion, activo);
		model.addAttribute("resultado", resultado);

		return "insertarCategorias";
	}

	
	@GetMapping("formulariomodificarcategorias")
	public String getFormularioModificarCategoria() {
		return "modificarCategorias";
	}

	@PostMapping("formulariomodificarcategorias")
	public String getFormulariosModificarCategorias(@RequestParam("id") String id,
			@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<CategoriasDTO> listaCategoria = categoriasService.buscarCategoria(id, nombre, descripcion, activo);
		model.addAttribute("lista", listaCategoria);

		return "modificarCategorias";
	}
	
	
	
	@GetMapping("modificarcategorias")
	public String getModificarCategorias() {
		return "modificarCategorias";
	}

	@PostMapping("modificarcategorias")
	public String modificarCategoria(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		categoriasService.modificarCategoria(id, nombre, descripcion, activo);

		return "modificarCategorias";
	}

	@GetMapping("formularioborrarcategorias")
	public String formularioBorrarCategoria() {

		return "borrarCategorias";

	}

	@PostMapping("formularioborrarcategorias")
	public String getFormulariosBorrarCategorias(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<CategoriasDTO> listaCategorias = categoriasService.buscarCategoria(id, nombre, descripcion, activo);
		model.addAttribute("lista", listaCategorias);

		return "borrarCategorias";
	}

	@PostMapping("borrarcategorias")
	public String borrarCategoria(@RequestParam("id") String id)
			throws ClassNotFoundException, SQLException, NamingException {
		categoriasService.borrarCategoria(id);

		return "borrarCategorias";
	}

}
