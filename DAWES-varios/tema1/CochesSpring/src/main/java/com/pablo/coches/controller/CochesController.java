package com.pablo.coches.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pablo.coches.negocio.CalculoCoches;
import com.pablo.coches.negocio.ICalculoCoches;

@Controller
public class CochesController {

	@Autowired
	ICalculoCoches coches;
	
	@RequestMapping(value = "/calcularcoches")
	public String calculo(@RequestParam ("nombre") String nombre, ModelMap model) throws IOException {
		Integer cantidad = coches.calculaCoches(nombre);
		model.addAttribute("nombre", nombre);
		model.addAttribute("cantidad", cantidad);
		return "resultado";
	}
}
