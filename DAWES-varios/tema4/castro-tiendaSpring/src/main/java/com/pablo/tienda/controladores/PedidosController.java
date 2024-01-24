
package com.pablo.tienda.controladores;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pablo.tienda.dao.IComboDAO;
import com.pablo.tienda.dtos.ClienteProductoDTO;
import com.pablo.tienda.dtos.ComboDTO;
import com.pablo.tienda.dtos.ItemDTO;
import com.pablo.tienda.dtos.PedidoDTO;
import com.pablo.tienda.negocio.IPedidosService;





@Controller
@RequestMapping("/pedidos/")
public class PedidosController {

	@Autowired
	IPedidosService pedidoService;
	@Autowired
	IComboDAO comboDAO;

	@PostMapping("/calculaprecio")

	public @ResponseBody Double calculaPrecio(ModelMap model, @RequestBody ClienteProductoDTO clienteProducto) {
		System.out.println(clienteProducto.getCliente() + " , " + clienteProducto.getProducto());
		return pedidoService.calcularPrecio(clienteProducto);
	}

	@PostMapping("/dopedido")
	public ResponseEntity<String> creaPedido(ModelMap model, @RequestBody List<ItemDTO> lista) {

		for (ItemDTO i : lista) {
			System.out.println(i.getClienteNombre() + " " + i.getProductoNombre());
		}
		// return ResponseEntity.ok("Operación realizada con éxito.");
		return ResponseEntity.internalServerError().body("Error al realizar la venta");

	}

	@GetMapping("listarpedidos")
	public String getListadoPedido(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		recuperacionCombos(model);
		return "pedidos/listarPedidos";
	}

	
	@PostMapping("listarpedido")
	public String buscarPedido(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "idCliente", required = false) String idCliente, @RequestParam("fecha") String fecha,
			@RequestParam(value = "idEstado", required = false) String idEstado, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		recuperacionCombos(model);
		
		List<PedidoDTO> listaPedido = pedidoService.buscarPedidos(id, idCliente, fecha, idEstado);
		model.addAttribute("lista", listaPedido);

		return "pedidos/listarPedidos";
	}

	
	@GetMapping("insertarpedido")
	public String getInsertarPedido(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		recuperacionCombos(model);
		return "pedidos/insertarPedido";
	}

	
	
	//ACTUALIZAR
	
//	
//	@GetMapping("formularioactualizarpedido")
//
//	public String getFormularioActualizarPedido(ModelMap model)
//			throws ClassNotFoundException, SQLException, NamingException {
//
//		recupercionCombos(model);
//
//		return "pedido/actualizarPedido";
//	}
//
//	@PostMapping("formularioactualizarpedido")
//	public String getFormularioActualizarPedido(@RequestParam(value = "id", required = false) String id,
//			@RequestParam(value = "idCliente", required = false) String idCliente,
//			@RequestParam(value = "fecha", required = false) String fecha,
//			@RequestParam(value = "idEstado", required = false) String idEstado, ModelMap model)
//			throws ClassNotFoundException, SQLException, NamingException {
//
//		List<PedidoDTO> listaPedido = pedidoService.buscarPedidos(id, idCliente, fecha, idEstado);
//		recupercionCombos(model);
//		model.addAttribute("lista", listaPedido);
//
//		return "pedido/actualizarPedido";
//	}
//
//	
//	
//	
//	@PostMapping("actualizarpedido")
//	public String actualizarPedido(@RequestParam("id") String id, @RequestParam("idCliente") String idCliente,
//			@RequestParam("idProducto") String idProducto, @RequestParam("cantidad") String cantidad,
//			@RequestParam("precio") String precio, ModelMap model)
//			throws ClassNotFoundException, SQLException, NamingException {
//
//		recupercionCombos(model);
//
//		pedidoService.actualizarPedido(id, idCliente, idProducto, cantidad, precio);
//
//		return "pedido/actualizarPedido";
//
//	}

	
	
	private void recuperacionCombos(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaCliente = comboDAO.recuperarCombosClientes();
		List<ComboDTO> listaProducto = comboDAO.recuperarCombosProductos();
		List<ComboDTO> listaEstadoPedido = comboDAO.recuperarCombosEstadoPedidos();

		model.addAttribute("comboCliente", listaCliente);
		model.addAttribute("comboProducto", listaProducto);
		model.addAttribute("comboEstadoPedido", listaEstadoPedido);
	}
















//	@PostMapping ("/calculaprecio")
//			public @ResponseBody Double calculaPrecio (ModelMap modelmap, @RequestBody  ClienteProductoDTO clienteProductoDTO) {
//		
//		System.out.println(clienteProductoDTO.getCliente()+ " " + clienteProductoDTO.getProducto());
//		return 3.0;
//	}
//	
//	@PostMapping("/dopedido")
//	public ResponseEntity<String> creaPedido(ModelMap modelMap, @RequestBody List<ItemDTO> lista) {
//		
//		for(ItemDTO i : lista) {
//			System.out.println(i.getClienteNombre() + " " + i.getProductoNombre());
//		}
//		
//	//	return ResponseEntity.ok("Operacion realizada con éxito");
//		
//		return ResponseEntity.internalServerError().body("Error al realizar la venta");
		
}

	