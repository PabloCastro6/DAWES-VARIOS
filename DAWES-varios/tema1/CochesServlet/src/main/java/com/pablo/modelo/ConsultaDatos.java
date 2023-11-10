package com.pablo.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class ConsultaDatos  {

	public String consultaCochesPorNombre(String nombre) throws IOException {

		int cuentaCoches = 0;

		String path = Thread.currentThread().getContextClassLoader().getResource("fichero.txt").getPath();
		File fichero = new File(path);
		
		BufferedReader lector = new BufferedReader(new FileReader(fichero));
		
		String linea;
		
		while ((linea = lector.readLine()) != null) {
			if (linea.contains(nombre)) {
				cuentaCoches++;
			}
		}

		return String.valueOf(cuentaCoches);

	}

}
