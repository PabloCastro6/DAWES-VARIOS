import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Prueba {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        
	        System.out.println("Ingrese el nombre del fichero de salida:");
	        String salidaFichero = scanner.nextLine();

	        try (PrintWriter out = new PrintWriter(new FileWriter(salidaFichero))) {

	           
	            System.out.println("Ingrese el nombre de un directorio:");
	            String directorio = scanner.nextLine();
	            File direc = new File(directorio);
	            if (direc.isDirectory()) {
	                for (String archivo : direc.list()) {
	                    System.out.println(archivo);
	                    out.println(archivo);
	                }
	            } else {
	                System.out.println("No es un directorio válido.");
	                out.println("No es un directorio válido.");
	            }

	            
	            System.out.println("Ingrese el nombre del fichero para buscar:");
	            String ficheroBusqueda = scanner.nextLine();
	            System.out.println("Ingrese la palabra a buscar:");
	            String palabra = scanner.nextLine().toLowerCase();
	            File archivoBusqueda = new File(directorio, ficheroBusqueda);
	            int contador = 0;
	            if (archivoBusqueda.exists() && archivoBusqueda.isFile()) {
	                try (BufferedReader reader = new BufferedReader(new FileReader(archivoBusqueda))) {
	                    String linea;
	                    while ((linea = reader.readLine()) != null) {
	                        if (linea.toLowerCase().contains(palabra)) {
	                            contador++;
	                        }
	                    }
	                }
	            }

	            
	            if (contador > 0) {
	                System.out.println("La palabra se encuentra en el archivo.");
	                out.println("La palabra se encuentra en el archivo.");
	            } else {
	                System.out.println("La palabra no se encuentra en el archivo.");
	                out.println("La palabra no se encuentra en el archivo.");
	            }
	            System.out.println("La palabra aparece " + contador + " veces.");
	            out.println("La palabra aparece " + contador + " veces.");

	        } catch (IOException e) {
	            System.err.println("Error al manejar el fichero: " + e.getMessage());
	        }
	    }
	}
