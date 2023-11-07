package com.pablo.descuentos.negocio;

import java.io.IOException;

import com.pablo.descuentos.modelo.ConsultaDatos;

public class Descuentos {

	public Integer calculaDescuento(String nombre) throws IOException {

		ConsultaDatos consultaDatos = new ConsultaDatos();
		if (consultaDatos.consultaEdad(nombre) < 20) {
			return 5;
		} else {
			return 10;
		}

	}

}
