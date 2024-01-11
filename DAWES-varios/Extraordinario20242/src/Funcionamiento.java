
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Funcionamiento {
private Scanner sc = new Scanner(System.in); 

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Introduce una palabra para buscar: ");
	String palabra = sc.nextLine();
	System.out.print("Introduce el fichero en el que buscar la palabra (" + palabra + "): ");
	String ficheroBusqueda = sc.nextLine();
	System.out.print("Introduce el fichero en el que escribir los resultados: ");
	String ficheroResultados = sc.nextLine();
	
	try {
		buscarPalabra(ficheroBusqueda, palabra, ficheroResultados);
	} catch (IOException exception) {
		System.err.println("No existe el archivo: " + exception.getMessage());
	}
	sc.close();
}
	
public static void buscarPalabra(String ficheroBusqueda, String palabra, String ficheroResultados) throws IOException {
	int contador = 0;
	FileReader fileReader = new FileReader(ficheroBusqueda);
	FileWriter fileWriter = new FileWriter(ficheroResultados);
	BufferedReader bufferedReader = new BufferedReader(fileReader);
	String line = bufferedReader.readLine();
	while (line != null) {

		for (String word : line.split(" ")) { 
			if (word.equalsIgnoreCase(palabra)) {
				contador++;

				fileWriter.write(line + "\n");

			}
		}
		line = bufferedReader.readLine();
	}
	String resultado;
	if (contador == 0) {
		resultado = "La palabra " + palabra + " no aparece ninguna vez.";
	} else {
		resultado = "La palabra " + palabra + " aparece " + contador + " veces.";
	}
	System.out.println(resultado);
	fileWriter.write(resultado + "\n");

	fileReader.close();
	fileWriter.close();
}

	
	public  void nombreFichero() throws IOException {
		System.out.println("Dame una ruta:");
		String ruta = sc.nextLine(); 

		File file = new File(ruta);
		File[] archivos = file.listFiles(); 
		
		for( File archivo : archivos ) { 
			System.out.println(archivo.getName());
			
			
		}
		String segundaRuta = "Resultado.txt";
		
		escribirListado(segundaRuta, archivos);
	}
	
	
	public void escribirListado(String ruta, File[] listado) throws IOException {
		File file = new File(ruta);
		FileWriter f = new FileWriter(file);
		
		for( File archivo : listado ) {  
			f.write(archivo.getName()); 
			f.write("\n");
			
		}
		f.close(); 
		
	}
}



