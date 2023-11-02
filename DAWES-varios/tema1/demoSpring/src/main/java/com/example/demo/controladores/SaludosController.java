package com.example.demo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SaludosController {
	
	@RequestMapping(value="hola")
	public String saludar() {
		return "saludo";
		
	}
	
	@RequestMapping(value="adios")
	public String agur() {
		return "goodbye";
		
	}

}