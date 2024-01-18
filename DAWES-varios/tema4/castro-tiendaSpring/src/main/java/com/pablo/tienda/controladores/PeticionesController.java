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
import com.pablo.tienda.dtos.PeticionesDTO;
import com.pablo.tienda.negocio.IPeticionesService;

public class PeticionesController {
	

	@Controller
	@RequestMapping("/peticiones")
	public class PeticicionesController {

		@Autowired
		IPeticionesService peticionesService;
		@Autowired
		IComboDAO combosDAO;

		@GetMapping("listarpeticiones")
		public String getListadoPeticiones(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

			//combos(model);

			return "peticiones/listarPeticiones";
		}

		@PostMapping("listarpeticiones")
		public String buscarPeticiones(@RequestParam("idPeticiones") String idPeticiones, @RequestParam("idCliente") String idCliente,
				@RequestParam("idProducto") String idProducto, @RequestParam("fecha") String fecha,
				@RequestParam("cantidad") String cantidad, @RequestParam("estado") String estado,
				ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

			List<PeticionesDTO> listaPeticiones = peticionesService.buscarPeticiones(idPeticiones, idCliente, idProducto,
					fecha, cantidad, estado);
		//	combos(model);

			model.addAttribute("lista", listaPeticiones);

			return "peticiones/listarPeticiones";
		}

}
}
