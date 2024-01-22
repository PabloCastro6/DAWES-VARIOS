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

import com.pablo.tienda.dtos.ProveedorDTO;
import com.pablo.tienda.negocio.IProveedoresService;

@Controller
@RequestMapping("/proveedores/")
public class ProveedorController {

	@Autowired
	IProveedoresService proveedoresService;

	@GetMapping("/listarproveedores")
	public String getListadoProveedores() {
		return "/proveedores/listadoProveedores";
	}

	@PostMapping("listarproveedores")
	public String buscarProveedores(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("contacto") String contacto, @RequestParam("telefono") String telefono,
			@RequestParam("correo") String correo, @RequestParam("direccion") String direccion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<ProveedorDTO> listaProveedores = proveedoresService.buscarProveedores(id, nombre, contacto, telefono,
				correo, direccion, activo);

		model.addAttribute("lista", listaProveedores);

		return "/proveedores/listadoProveedores";
	}

	@GetMapping("insertarproveedores")
	public String getFormularioInsertarCategoria(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		return "/proveedores/insertarProveedores";
	}

	@PostMapping("insertarproveedores")
	public String insertarProveedores(@RequestParam("nombre") String nombre, @RequestParam("contacto") String contacto,
			@RequestParam("telefono") String telefono, @RequestParam("correo") String correo,
			@RequestParam("direccion") String direccion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";
		Integer resultado = proveedoresService.insertarProveedores(nombre, contacto, telefono, correo, direccion,
				activo);

		model.addAttribute("resultado", resultado);

		return "/proveedores/insertarProveedores";
	}

	@GetMapping("formularioactualizarproveedor")

	public String getFormularioActualizarProveedores(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		return "/proveedores/actualizarProveedores";
	}

	@PostMapping("formularioactualizarproveedor")
	public String getFormularioActualizarProveedores(@RequestParam("id") String id,
			@RequestParam("nombre") String nombre, @RequestParam("contacto") String contacto,
			@RequestParam("telefono") String telefono, @RequestParam("correo") String correo,
			@RequestParam("direccion") String direccion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<ProveedorDTO> listaProveedores = proveedoresService.buscarProveedores(id, nombre, contacto, telefono,
				correo, direccion, activo);

		model.addAttribute("lista", listaProveedores);

		return "/proveedores/actualizarProveedores";
	}

	@PostMapping("actualizarproveedor")
	public String actualizarProveedores(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("contacto") String contacto, @RequestParam("telefono") String telefono,
			@RequestParam("correo") String correo, @RequestParam("direccion") String direccion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		proveedoresService.actualizarProveedores(id, nombre, contacto, telefono, correo, direccion, activo);

		return "/proveedores/actualizarProveedores";
	}

	@GetMapping("formularioborrarproveedor")

	public String getFormularioBorrarProveedor(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		return "/proveedores/borrarProveedores";
	}

	@PostMapping("formularioborrarproveedor")
	public String getFormularioBorrarProveedores(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("contacto") String contacto, @RequestParam("telefono") String telefono,
			@RequestParam("correo") String correo, @RequestParam("direccion") String direccion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";
		List<ProveedorDTO> listaProveedores = proveedoresService.buscarProveedores(id, nombre, contacto, telefono,
				correo, direccion, activo);

		model.addAttribute("lista", listaProveedores);

		return "/proveedores/borrarProveedores";
	}

	@PostMapping("borrarproveedor")
	public String borrarProveedor(@RequestParam("id") String id)
			throws ClassNotFoundException, SQLException, NamingException {

		proveedoresService.borrarProveedores(id);

		return "/proveedores/borrarProveedores";
	}
}
