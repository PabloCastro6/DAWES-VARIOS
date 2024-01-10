package Principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

	public int hayPalabras() throws FileNotFoundException, IOException {
		int contador = 0;
		try (FileReader fr = new FileReader(Funcionamiento.palabraABuscar);
				BufferedReader br = new BufferedReader(fr)) {
			while (br.readLine() != null) {
				contador++;
			}
		}

		return contador;
	}

	public String[] crearArrayPalabras() throws FileNotFoundException, IOException {
		String[] palabras = new String[hayPalabras()];
		try (FileReader fr = new FileReader(Funcionamiento.palabraABuscar);
				BufferedReader br = new BufferedReader(fr)) {

			String linea;
			int contador = 0;
			while ((linea = br.readLine()) != null) {
				palabras[contador] = linea;
				contador++;
			}
		}

		return palabras;
	}

	public int[] crearArrayRepeticion() throws FileNotFoundException, IOException {
		int[] repeticion = new int[hayPalabras()] ;
		
		for (int i = 0; i < hayPalabras(); i++) {
			repeticion[i] = 0;
		}
		
		return repeticion;
	}

	public int[] contarRepeticiones(String[] array) throws FileNotFoundException, IOException {
		int [] repeticion = crearArrayRepeticion();
		String[] palabras = array;
		try (FileReader fr = new FileReader(Funcionamiento.ficheroDeBuscar);
			BufferedReader br = new BufferedReader(fr)) {
				String linea;
				while((linea = br.readLine()) != null) {
					System.out.println(linea);
					System.out.println("la palabra "+Funcionamiento.palabraABuscar +"aparece" +repeticion.length);
					String[] palabrasLinea = linea.split("\\s+");
					for(String palabra : palabrasLinea) {
						for (int i = 0; i < palabras.length; i++) {
							if(palabra.equalsIgnoreCase(palabras[i])) {
								repeticion[i]++;
							} else if (palabra.toLowerCase().contains(palabras[i].toLowerCase())) {
								repeticion[i]++;
							}
						}
					}
				}
			
		}
		return repeticion;
	}
	}

