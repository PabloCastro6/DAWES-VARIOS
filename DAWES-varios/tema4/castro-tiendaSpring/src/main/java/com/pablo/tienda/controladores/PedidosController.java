package com.pablo.tienda.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pablo.tienda.dtos.ClienteProductoDTO;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {
	
	
	@PostMapping ("/calculaprecio")
			public @ResponseBody Double calculaPrecio (ModelMap modelmap, @RequestBody  ClienteProductoDTO clienteProductoDTO) {
		
		System.out.println(clienteProductoDTO.getCliente()+ " " + clienteProductoDTO.getProducto());
		return 3.0;
	}
}
	