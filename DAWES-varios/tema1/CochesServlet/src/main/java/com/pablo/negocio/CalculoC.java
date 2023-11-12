package com.pablo.negocio;

import java.io.BufferedReader;
import java.io.IOException;

import com.pablo.modelo.ConsultaDatos;

public class CalculoC {
	
	public Integer calculaCoches(String nombre) throws IOException {
		
		ConsultaDatos consultaDatos = new ConsultaDatos();
		BufferedReader lector = consultaDatos.accesoADatos(nombre);
		String linea;
		int contador = 0;

		while((linea = lector.readLine()) != null) {
			if (linea.contains(nombre)) {
				contador++;
			}
		}
		return contador;
	}
	
}
