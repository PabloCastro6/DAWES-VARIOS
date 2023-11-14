package com.pablo.coches.negocio;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pablo.coches.model.ConsultaDatos;

@Component
public class CalculoCoches implements ICalculoCoches {

	@Autowired
	ConsultaDatos consultaDatos;

	public Integer calculaCoches(String nombre) throws IOException {

		BufferedReader lector = consultaDatos.accesoADatos(nombre);
		String linea;
		int contador = 0;

		while ((linea = lector.readLine()) != null) {
			if (linea.contains(nombre)) {
				contador++;
			}
		}
		return contador;
	}

}
