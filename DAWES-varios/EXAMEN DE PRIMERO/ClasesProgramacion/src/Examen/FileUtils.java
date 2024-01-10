package Examen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileUtils {
	
	public int hayPalabras() throws IOException {
		int contador = 0;
		try (FileReader fr = new FileReader (Funcionamiento.palabraBuscar);
				BufferedReader br = new BufferedReader(fr)) {
			while (br.readLine() != null) {
				contador++;
			}
			
		}
		return contador;
	}

	
	public void crearArrayPalabras() throws IOException {
		String[] palabras = new String[hayPalabras()];
		try (FileReader fr = new FileReader(Funcionamiento.palabraBuscar);
				BufferedReader br = new BufferedReader(fr)) {
			
			String linea;
			int contador = 0;
			while ((linea = br.readLine())!= null) {
				palabras[contador] = linea;
				contador++;
			}
		}
				
	}
}
