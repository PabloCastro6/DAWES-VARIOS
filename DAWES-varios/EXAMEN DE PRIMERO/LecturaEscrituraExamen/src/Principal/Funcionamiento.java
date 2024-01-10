package Principal;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Funcionamiento {
	
	public static String palabraABuscar;
	
	
	public static String ficheroDeBuscar;
	
	
	FileUtils fichero = new FileUtils();
	
	
	Scanner sc = new Scanner (System.in);
	
	public void flujo() {
		System.out.println("dime el fichero en el que debo buscar");
		ficheroDeBuscar=sc.nextLine();
		System.out.println("dime la palabra que debo buscar");
		palabraABuscar=sc.nextLine();
		System.out.println("dime el fichero en el que debo escribir");
		String ficheroPaEscribir = sc.nextLine();
		
		
		Path ficheroDeleer = Paths.get(ficheroDeBuscar);
		Path ficheroDeEscribir = Paths.get(ficheroPaEscribir);
		
		if (Files.exists(ficheroDeleer) && Files.exists(ficheroDeEscribir)) {
			File file = new File(ficheroPaEscribir);
			file.getParentFile().mkdirs();
		}else {
			System.out.println("El fichero donde debo buscar No existe");
		}
			}

}
