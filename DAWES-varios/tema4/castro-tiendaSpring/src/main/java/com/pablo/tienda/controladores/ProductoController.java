package com.pablo.tienda.controladores;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pablo.tienda.dao.IComboDAO;
import com.pablo.tienda.dtos.ComboDTO;
import com.pablo.tienda.dtos.ProductoDTO;
import com.pablo.tienda.negocio.IProductosService;


@Controller
@RequestMapping("productos")
public class ProductoController {

	private static Logger logger = LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	IProductosService productoService;
	@Autowired
	IComboDAO comboDAO;

	@GetMapping("listarproducto")
	public String getListadoProducto(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		recuperacionCombos(model);

		return "productos/listarProducto";
	}

	@PostMapping("listarproducto")
	public String buscarProducto(@RequestParam("idCategoria") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, @RequestParam("precio") String precio,
			@RequestParam("cantidadStock") String cantidadStock, @RequestParam("idCategoria") String idCategoria,
			@RequestParam("idProveedor") String idProveedor, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ProductoDTO> listaProducto = productoService.buscarProducto(idCategoria, nombre, descripcion, precio,
				cantidadStock, idCategoria, idProveedor);

		recuperacionCombos(model);
		model.addAttribute("lista", listaProducto);

		return "productos/listarProducto";
	}

	@GetMapping("insertarproducto")
	public String getFormularioInsertarProducto(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		recuperacionCombos(model);

		return "productos/insertarProducto";

	}

	@PostMapping("insertarproducto")
	public String insertarProducto(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, @RequestParam("precio") String precio,
			@RequestParam( "cantidadStock") String cantidadStock, @RequestParam("idCategoria") String idCategoria,
			@RequestParam("idProveedor") String idProveedor, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		
		precio = (precio == "") ? "0" : precio;
		cantidadStock = (cantidadStock == "") ? "0" : cantidadStock;

		recuperacionCombos(model);
		Integer resultado = productoService.insertarProducto(nombre, descripcion, precio, cantidadStock, idCategoria,
				idProveedor);
		
		model.addAttribute("resultado", resultado);

		return "productos/insertarProducto";

	}

	
	@GetMapping("modificarproducto")
	public String getFormularioModificarProducto(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		
		recuperacionCombos(model);

		return "productos/modificarProducto";
	}

	@PostMapping("formulariomodificarproducto")
	public String getFormularioModificarProducto(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, @RequestParam("precio") String precio,
			@RequestParam("cantidadStock") String cantidadStock, @RequestParam("idCategoria") String idCategoria,
			@RequestParam("idProveedor") String idProveedor, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ProductoDTO> listaProducto = productoService.buscarProducto(id, nombre, descripcion, precio,
				cantidadStock, idCategoria, idProveedor);
		
		recuperacionCombos(model);
		model.addAttribute("lista", listaProducto);

		return "productos/modificarProducto";
	}

	@PostMapping("modificarproducto")
	public String modificarProducto(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, @RequestParam("precio") String precio,
			@RequestParam("cantidadStock") String cantidadStock, @RequestParam("idCategoria") String idCategoria,
			@RequestParam("idProveedor") String idProveedor, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		

		precio = (precio == "") ? "0" : precio;
		cantidadStock = (cantidadStock == "") ? "0" : cantidadStock;
		
		recuperacionCombos(model);

		productoService.modificarProducto(id, nombre, descripcion, precio, cantidadStock, idCategoria, idProveedor);

		return "productos/modificarProducto";

	}
	
	private void recuperacionCombos(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaCategoria = comboDAO.recuperaCombosCategorias();

		List<ComboDTO> listaProveedores = comboDAO.recuperaCombosProveedores();

		model.addAttribute("comboCategorias", listaCategoria);
		model.addAttribute("comboProveedores", listaProveedores);
	}


}

