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

import com.pablo.tienda.dao.IComboDAO;
import com.pablo.tienda.dtos.ComboDTO;
import com.pablo.tienda.dtos.PeticionesDTO;
import com.pablo.tienda.negocio.IPeticionesService;


@Controller
@RequestMapping("/peticiones")
public class PeticionesController {

	@Autowired
	IPeticionesService peticionesService;
	@Autowired
	IComboDAO combosDAO;

	@GetMapping("listarpeticion")
	public String getListadoPeticiones(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaCliente = combosDAO.recuperarCombosClientes();
		List<ComboDTO> listaProducto = combosDAO.recuperarCombosProductos();
		List<ComboDTO> listaEstadoPedido = combosDAO.recuperarCombosEstadoPedidos();

		model.addAttribute("comboCliente", listaCliente);
		model.addAttribute("comboProducto", listaProducto);
		model.addAttribute("comboEstadoPedido", listaEstadoPedido);

		return "peticiones/listadoPeticiones";
	}

	@PostMapping("listarpeticiones")
	public String buscarPeticiones(@RequestParam("idPeticiones") String idPeticiones,
			@RequestParam("idCliente") String idCliente, @RequestParam("idProducto") String idProducto,
			@RequestParam("fecha") String fecha, @RequestParam("cantidad") String cantidad,
			@RequestParam("estado") String estado, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		if(fecha.equals("")) {
			fecha = "1970/1/1";
		}
		
		if(cantidad.equals("")) {
			cantidad = "0";
		}
		
		List<PeticionesDTO> listaPeticiones = peticionesService.buscarPeticiones(idPeticiones, idCliente, idProducto,
				fecha, cantidad, estado);

		List<ComboDTO> listaCliente = combosDAO.recuperarCombosClientes();
		List<ComboDTO> listaProducto = combosDAO.recuperarCombosProductos();
		List<ComboDTO> listaEstadoPedido = combosDAO.recuperarCombosEstadoPedidos();

		model.addAttribute("comboCliente", listaCliente);
		model.addAttribute("comboProducto", listaProducto);
		model.addAttribute("comboEstadoPedido", listaEstadoPedido);

		model.addAttribute("lista", listaPeticiones);

		return "peticiones/listadoPeticiones";
	}

	@GetMapping("insertarpeticion")
	public String getFormularioInsertarPeticion(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaCliente = combosDAO.recuperarCombosClientes();
		List<ComboDTO> listaProducto = combosDAO.recuperarCombosProductos();
		List<ComboDTO> listaEstadoPedido = combosDAO.recuperarCombosEstadoPedidos();

		model.addAttribute("comboCliente", listaCliente);
		model.addAttribute("comboProducto", listaProducto);
		model.addAttribute("comboEstadoPedido", listaEstadoPedido);

		return "peticiones/insertarPeticiones";

	}

	@PostMapping("insertarpeticion")
	public String insertarPeticion(@RequestParam("idCliente") String idCliente,
			@RequestParam("idProducto") String idProducto, @RequestParam("cantidad") String cantidad,
			@RequestParam("idEstadoPedido") String idEstadoPedido, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaCliente = combosDAO.recuperarCombosClientes();
		List<ComboDTO> listaProducto = combosDAO.recuperarCombosProductos();
		List<ComboDTO> listaEstadoPedido = combosDAO.recuperarCombosEstadoPedidos();

		model.addAttribute("comboCliente", listaCliente);
		model.addAttribute("comboProducto", listaProducto);
		model.addAttribute("comboEstadoPedido", listaEstadoPedido);
		Integer resultado = peticionesService.insertarPeticiones(idCliente, idProducto, cantidad, idEstadoPedido);

		model.addAttribute("resultado", resultado);

		return "peticiones/insertarPeticiones";

	}

	@GetMapping("formularioactualizarpeticion")
	public String getFormularioActualizarPeticion(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaCliente = combosDAO.recuperarCombosClientes();
		List<ComboDTO> listaProducto = combosDAO.recuperarCombosProductos();
		List<ComboDTO> listaEstadoPedido = combosDAO.recuperarCombosEstadoPedidos();

		model.addAttribute("comboCliente", listaCliente);
		model.addAttribute("comboProducto", listaProducto);
		model.addAttribute("comboEstadoPedido", listaEstadoPedido);

		return "/peticiones/actualizarPeticiones";
	}

	@PostMapping("formularioactualizarpeticion")
	public String formularioActualizarPeticiones(@RequestParam("idPeticiones") String idPeticiones,
			@RequestParam("idCliente") String idCliente, @RequestParam("idProducto") String idProducto,
			@RequestParam("fecha") String fecha, @RequestParam("cantidad") String cantidad,
			@RequestParam("estado") String estado, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		if(fecha.equals("")) {
			fecha = "1970/1/1";
		}
		
		if(cantidad.equals("")) {
			cantidad = "0";
		}
		
		List<PeticionesDTO> listaPeticiones = peticionesService.buscarPeticiones(idPeticiones, idCliente, idProducto,
				fecha, cantidad, estado);

		List<ComboDTO> listaCliente = combosDAO.recuperarCombosClientes();
		List<ComboDTO> listaProducto = combosDAO.recuperarCombosProductos();
		List<ComboDTO> listaEstadoPedido = combosDAO.recuperarCombosEstadoPedidos();

		model.addAttribute("comboCliente", listaCliente);
		model.addAttribute("comboProducto", listaProducto);
		model.addAttribute("comboEstadoPedido", listaEstadoPedido);

		model.addAttribute("lista", listaPeticiones);

		return "/peticiones/actualizarPeticiones";
	}

	@PostMapping("actualizarpeticiones")
	public String actualizarPeticiones(@RequestParam("idPeticiones") String idPeticiones,
			@RequestParam("idCliente") String idCliente, @RequestParam("idProducto") String idProducto,
			@RequestParam("fecha") String fecha, @RequestParam("cantidad") String cantidad,
			@RequestParam("estado") String estado, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaCliente = combosDAO.recuperarCombosClientes();
		List<ComboDTO> listaProducto = combosDAO.recuperarCombosProductos();
		List<ComboDTO> listaEstadoPedido = combosDAO.recuperarCombosEstadoPedidos();

		model.addAttribute("comboCliente", listaCliente);
		model.addAttribute("comboProducto", listaProducto);
		model.addAttribute("comboEstadoPedido", listaEstadoPedido);

		peticionesService.actualizarPeticiones(idPeticiones, idCliente, idProducto, cantidad, fecha, estado);

		return "/peticiones/actualizarPeticiones";
	}
	
	@GetMapping("formularioborrarpeticion")
	public String getFormularioBorrarPeticiones(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
	    
		List<ComboDTO> listaCliente = combosDAO.recuperarCombosClientes();
		List<ComboDTO> listaProducto = combosDAO.recuperarCombosProductos();
		List<ComboDTO> listaEstadoPedido = combosDAO.recuperarCombosEstadoPedidos();

		model.addAttribute("comboCliente", listaCliente);
		model.addAttribute("comboProducto", listaProducto);
		model.addAttribute("comboEstadoPedido", listaEstadoPedido);
		
		return "/peticiones/borrarPeticiones";
	}

	@PostMapping("formularioborrarpeticion")
	public String formularioBorrarPeticiones(@RequestParam("idPeticiones") String idPeticiones, @RequestParam("idCliente") String idCliente,
			@RequestParam("idProducto") String idProducto, @RequestParam("fecha") String fecha,
			@RequestParam("cantidad") String cantidad, @RequestParam("estado") String estado,
			ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaCliente = combosDAO.recuperarCombosClientes();
		List<ComboDTO> listaProducto = combosDAO.recuperarCombosProductos();
		List<ComboDTO> listaEstadoPedido = combosDAO.recuperarCombosEstadoPedidos();

		model.addAttribute("comboCliente", listaCliente);
		model.addAttribute("comboProducto", listaProducto);
		model.addAttribute("comboEstadoPedido", listaEstadoPedido);

		if(fecha.equals("")) {
			fecha = "1970/1/1";
		}
		
		if(cantidad.equals("")) {
			cantidad = "0";
		}
		
		List<PeticionesDTO> listaPeticiones = peticionesService.buscarPeticiones(idPeticiones, idCliente, idProducto,
				fecha, cantidad, estado);
		
		model.addAttribute("lista", listaPeticiones);

	    return "/peticiones/borrarPeticiones";
	}

	@PostMapping("borrarpeticiones")
	public String borrarPeticiones(@RequestParam("idPeticiones") String idPeticiones, ModelMap model)
	        throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaCliente = combosDAO.recuperarCombosClientes();
		List<ComboDTO> listaProducto = combosDAO.recuperarCombosProductos();
		List<ComboDTO> listaEstadoPedido = combosDAO.recuperarCombosEstadoPedidos();

		model.addAttribute("comboCliente", listaCliente);
		model.addAttribute("comboProducto", listaProducto);
		model.addAttribute("comboEstadoPedido", listaEstadoPedido);
		
	    peticionesService.borrarPeticiones(idPeticiones);

	    return "/peticiones/borrarPeticiones";
	}
	
}



