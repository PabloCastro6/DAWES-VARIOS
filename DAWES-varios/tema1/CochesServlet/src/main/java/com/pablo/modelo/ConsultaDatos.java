package com.pablo.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsultaDatos {

	public String consultaCochesPorNombre(String nombre) throws IOException {

		int cuentaCoches = 0;

		try (InputStream inputStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("fichero.txt");
				BufferedReader lector = new BufferedReader(new InputStreamReader(inputStream))) {
			String linea;

			while ((linea = lector.readLine()) != null) {
				if (linea.contains(nombre)) {
					cuentaCoches++;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}

		return String.valueOf(cuentaCoches);

	}

}
