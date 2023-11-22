package com.pablo.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pablo.dtos.Persona;
import com.pablo.dtos.Provincia;

@Controller
public class Controlador {

	@RequestMapping("/obtenpersonas")
	
	public String lista(ModelMap model) {
		
		List<Persona> listaPersonas = new ArrayList<Persona>();
		
		listaPersonas.add( new Persona("Pepe", 2001));
		listaPersonas.add(new Persona("kike",100000));
		listaPersonas.add(new Persona("Juanita",-5000));
		listaPersonas.add(new Persona("Pablo",3000));
		
		model.addAttribute("listaPersonas", listaPersonas);
		
		
		List<Provincia> listaProvincias = new ArrayList<Provincia>();
		
		listaProvincias.add( new Provincia("Salamanca",1));
		listaProvincias.add(new Provincia("Zamora",2));
		listaProvincias.add(new Provincia("Avila",3));
		listaProvincias.add(new Provincia("Valladolid",4));
		
		model.addAttribute("listaProvincias", listaProvincias);
		
		return "lista";
		
		
	

	}
}