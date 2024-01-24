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
import com.pablo.tienda.dtos.ClienteDTO;
import com.pablo.tienda.dtos.ComboDTO;
import com.pablo.tienda.negocio.IClientesService;



@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	IClientesService clientesService;
	@Autowired
	IComboDAO combosDAO;

	@GetMapping("listarcliente")
	public String getListadoCliente(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);
		
		return "clientes/listadoClientes";
	}

	@PostMapping("listarcliente")
	public String buscarCliente(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam(value = "correo", required = false) String correo,
			@RequestParam("idPoblacion") String idPoblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<ClienteDTO> listaCliente = clientesService.buscarClientes(id, nombre, correo, idPoblacion, activo);

		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);
		
		model.addAttribute("lista", listaCliente);

		return "clientes/listadoClientes";
	}

	@GetMapping("insertarcliente")
	public String getFormularioInsertarCliente(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);

		return "clientes/insertarClientes";

	}

	@PostMapping("insertarcliente")
	public String insertarCliente(@RequestParam("nombre") String nombre,
			@RequestParam("correo") String correo,
			@RequestParam("idPoblacion") String idPoblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);
		
		Integer resultado = clientesService.insertarClientes(nombre, correo, idPoblacion, activo);

		model.addAttribute("resultado", resultado);

		return "clientes/insertarClientes";

	}
	
	@GetMapping("formulariomodificarcliente")
	public String getFormularioModificarCliente(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);

		return "clientes/modificarClientes";

	}
	
	@PostMapping("formulariomodificarcliente")
	public String getFormularioModificarClientes(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam(value = "correo", required = false) String correo,
			@RequestParam("idPoblacion") String idPoblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<ClienteDTO> listaCliente = clientesService.buscarClientes(id, nombre, correo, idPoblacion, activo);

		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);
		
		model.addAttribute("lista", listaCliente);

		return "clientes/modificarClientes";
	}
	
	@PostMapping("modificarcliente")
	public String Clientes(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam(value = "correo", required = false) String correo,
			@RequestParam("idPoblacion") String idPoblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";
		
		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);

		clientesService.modificarClientes(id, nombre, correo, idPoblacion, activo);

		return "clientes/modificarClientes";
	}
	
	@GetMapping("formularioborrarcliente")
	public String getFormularioBorrarCliente(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);

		return "clientes/borrarClientes";

	}
	
	@PostMapping("formularioborrarcliente")
	public String borrarCliente(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam(value = "correo", required = false) String correo,
			@RequestParam("idPoblacion") String idPoblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<ClienteDTO> listaCliente = clientesService.buscarClientes(id, nombre, correo, idPoblacion, activo);

		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);
		
		model.addAttribute("lista", listaCliente);

		return "clientes/borrarClientes";
	}
	
	@PostMapping("borrarclientes")
	public String borrarCliente(@RequestParam("id") String id, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);
		
		clientesService.borrarClientes(id);
		
		return "clientes/borrarClientes";
	}


}
