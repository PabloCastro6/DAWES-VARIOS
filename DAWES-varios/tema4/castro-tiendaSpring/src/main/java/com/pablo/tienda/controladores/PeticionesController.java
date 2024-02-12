package com.pablo.tienda.controladores;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pablo.tienda.dao.IComboDAO;
import com.pablo.tienda.dtos.ComboDTO;
import com.pablo.tienda.dtos.PeticionesDTO;
import com.pablo.tienda.negocio.IPeticionesService;

@Controller
@RequestMapping("/peticiones")
public class PeticionesController {

	@Autowired
	IPeticionesService peticionesService;
	@Qualifier("combospringdatajpa")
	@Autowired
	IComboDAO combosDAO;

	@GetMapping("listarpeticiones")
	public String getListadoPeticiones(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		combos(model);

		return "peticiones/listarPeticiones";
	}

	@PostMapping("listarpeticiones")
	public String buscarPeticiones(@RequestParam("idPeticiones") String idPeticiones,
			@RequestParam("idCliente") String idCliente, @RequestParam("idProducto") String idProducto,
			@RequestParam("fecha") String fecha, @RequestParam("cantidad") String cantidad,
			@RequestParam("estado") String estado, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<PeticionesDTO> listaPeticiones = peticionesService.buscarPeticiones(idPeticiones, idCliente, idProducto,
				fecha, cantidad, estado);
		combos(model);

		model.addAttribute("lista", listaPeticiones);

		return "peticiones/listarPeticiones";
	}

	@GetMapping("insertarpeticiones")
	public String getFormularioInsertarPeticion(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		combos(model);

		return "peticiones/insertarPeticiones";

	}

	@PostMapping("insertarpeticiones")
	public String insertarPeticion(@RequestParam("idCliente") String idCliente,
			@RequestParam("idProducto") String idProducto, @RequestParam("cantidad") String cantidad,
			@RequestParam("idEstadoPedido") String idEstadoPedido, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		combos(model);
		Integer resultado = peticionesService.insertarPeticiones(idCliente, idProducto, cantidad, idEstadoPedido);

		model.addAttribute("resultado", resultado);

		return "peticiones/insertarPeticiones";

	}

	@GetMapping("formularioactualizarpeticiones")
	public String getFormularioActualizarPeticion(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		combos(model);

		return "/peticiones/actualizarPeticiones";
	}

	@PostMapping("formularioactualizarpeticiones")
	public String formularioActualizarPeticiones(@RequestParam("idPeticiones") String idPeticiones,
			@RequestParam("idCliente") String idCliente, @RequestParam("idProducto") String idProducto,
			@RequestParam("fecha") String fecha, @RequestParam("cantidad") String cantidad,
			@RequestParam("estado") String estado, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<PeticionesDTO> listaPeticiones = peticionesService.buscarPeticiones(idPeticiones, idCliente, idProducto,
				fecha, cantidad, estado);

		combos(model);

		model.addAttribute("lista", listaPeticiones);

		return "/peticiones/actualizarPeticiones";
	}

	@PostMapping("actualizarpeticiones")
	public String actualizarPeticiones(@RequestParam("idPeticiones") String idPeticiones,
			@RequestParam("idCliente") String idCliente, @RequestParam("idProducto") String idProducto,
			@RequestParam("fecha") String fecha, @RequestParam("cantidad") String cantidad,
			@RequestParam("estado") String estado, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		combos(model);

		peticionesService.actualizarPeticiones(idPeticiones, idCliente, idProducto, fecha, cantidad, estado);

		return "/peticiones/actualizarPeticiones";
	}

	@GetMapping("formularioborrarpeticiones")
	public String getFormularioBorrarPeticiones(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		combos(model);

		return "/peticiones/borrarPeticiones";
	}

	@PostMapping("formularioborrarpeticiones")
	public String formularioBorrarPeticiones(@RequestParam("idPeticiones") String idPeticiones,
			@RequestParam("idCliente") String idCliente, @RequestParam("idProducto") String idProducto,
			@RequestParam("fecha") String fecha, @RequestParam("cantidad") String cantidad,
			@RequestParam("estado") String estado, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		combos(model);

		List<PeticionesDTO> listaPeticiones = peticionesService.buscarPeticiones(idPeticiones, idCliente, idProducto,
				fecha, cantidad, estado);

		model.addAttribute("lista", listaPeticiones);

		return "/peticiones/borrarPeticiones";
	}

	@PostMapping("borrarpeticiones")
	public String borrarPeticiones(@RequestParam("idPeticiones") String idPeticiones, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		combos(model);

		peticionesService.borrarPeticiones(idPeticiones);

		return "/peticiones/borrarPeticiones";
	}

	private void combos(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaCliente = combosDAO.recuperarCombosClientes();
		List<ComboDTO> listaProducto = combosDAO.recuperarCombosProductos();
		List<ComboDTO> listaEstadoPedido = combosDAO.recuperarCombosEstadoPedidos();

		model.addAttribute("comboCliente", listaCliente);
		model.addAttribute("comboProducto", listaProducto);
		model.addAttribute("comboEstadoPedido", listaEstadoPedido);
	}

}
