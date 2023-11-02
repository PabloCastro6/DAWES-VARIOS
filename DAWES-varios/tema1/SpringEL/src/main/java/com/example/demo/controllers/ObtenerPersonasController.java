package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dtos.PersonaDTO;

@Controller
public class ObtenerPersonasController {
	
	@RequestMapping(value="/obtenPersona")
	public String daPersona(ModelMap model) {
		
		PersonaDTO p = new PersonaDTO(55, "Juanito");
		model.addAttribute("persona", p);
		
		return "hola";
		
	}

}
