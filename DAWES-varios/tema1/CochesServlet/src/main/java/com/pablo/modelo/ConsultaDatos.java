package com.pablo.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConsultaDatos {
	
	public BufferedReader accesoADatos(String nombre) throws IOException {
		
		String path = Thread.currentThread().getContextClassLoader().getResource("fichero.txt").getPath();
		File file = new File(path);
		BufferedReader lector = new BufferedReader(new FileReader(file));
		return lector;

	}

}
