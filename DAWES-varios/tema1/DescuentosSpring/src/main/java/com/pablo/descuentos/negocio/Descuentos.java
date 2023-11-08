package com.pablo.descuentos.negocio;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import com.pablo.descuentos.modelo.IConsultaDatos;


@Component
public class Descuentos implements IDescuentos {
	
	@Autowired 
	@Qualifier("consultaBBDD")
	IConsultaDatos consultaDatos; 
	
	public Integer calculaDescuento(String nombre) throws IOException {

	//	ConsultaDatos consultaDatos = new ConsultaDatos();
		if (consultaDatos.consultaEdad(nombre) < 20) {
			return 5;
		} else {
			return 10;
		}

	}

}
