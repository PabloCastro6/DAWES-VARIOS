import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Funcionamiento {

	private Scanner sc = new Scanner(System.in); //Crear un Scanner general de la consola 
	
	
	public  void flujoPrincipal() throws IOException {
		System.out.println("Dame una ruta:");
		String ruta = sc.nextLine(); // Funcion para leer de la consola
		 // String ruta = "C:\\Users\\Usuario\\Desktop\\1DAW\\PROGRAMACION\\programacion Jesus\\programacion\\Tema 5\\SuperGrep\\src\\com\\jesus\\superGrep";
		File file = new File(ruta);
		File[] archivos = file.listFiles(); //ListFiles se usa para listar un directorio 
		
		for( File archivo : archivos ) { //Recorrer el array archivos
			System.out.println(archivo.getName());
			
			
		}
		String segundaRuta = "Resultado.txt";
		
		escribirListado(segundaRuta, archivos);
	}
	
	
	public void escribirListado(String ruta, File[] listado) throws IOException {
		File file = new File(ruta);
		FileWriter f = new FileWriter(file);
		
		for( File archivo : listado ) {  //Recorrer el array archivos
			f.write(archivo.getName()); //Escribir en el file el nombre de cada archivo del listado
			f.write("\n");
			
		}
		f.close(); //IMPORTANTE cerrar el archivo 
		
	}
	
	public void copiarArchivo(String ruta, String nuevoRuta) throws IOException {
		File origen = new File(ruta);
		File destino = new File(nuevoRuta);
		
		
		FileReader fileReader = new FileReader(origen);
		BufferedReader bufferReader = new BufferedReader(fileReader);
		FileWriter fileWriter = new FileWriter(destino);
		
		String linea = bufferReader.readLine(); //Leer una linea;
		
		while(linea != null) {
			fileWriter.write(linea);
			fileWriter.write("\n");
			
			
			
			linea = bufferReader.readLine();

		}
		
		fileWriter.close();
		bufferReader.close();
		fileReader.close();
		
	}

}
