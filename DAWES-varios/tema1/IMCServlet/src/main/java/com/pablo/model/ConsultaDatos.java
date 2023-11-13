package com.pablo.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConsultaDatos {

public String accesoDatos(String nombre) throws IOException {
		
		String path = Thread.currentThread().getContextClassLoader().getResource("fichero.txt").getPath();
		File file = new File(path);
		BufferedReader lector = new BufferedReader(new FileReader(file));
		String linea;

		while((linea = lector.readLine()) != null) {
			if (linea.contains(nombre)) {
				return linea;
			}
		}
		
		return null;
	}
}

