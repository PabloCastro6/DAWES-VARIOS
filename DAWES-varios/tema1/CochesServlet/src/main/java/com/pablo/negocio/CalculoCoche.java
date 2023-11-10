package com.pablo.negocio;

import java.io.IOException;

import com.pablo.modelo.ConsultaDatos;

public class CalculoCoche {

	public int numeroDeCoches(String nombre) throws IOException {
		String rutaFichero = "";
		
		ConsultaDatos consulta = new ConsultaDatos();
		String[] datos = consulta.consultaCochesPorNombre(nombre).split("-");
		int numeroDeCoches = 0;

		for (String dato : datos) {
			if (dato.equals(nombre)) {
				numeroDeCoches++;
			}
		}

		return numeroDeCoches;
	}
}