package Examen;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Funcionamiento {
	
	public static String palabraBuscar;
	
	public static String ficheroDeBuscar;
	
	
	Scanner sc = new Scanner (System.in);
	
	
	public static void main (String args[]) {
		menu ();
	}

	
	
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime la palabra que debo buscar");
		palabraBuscar = sc.nextLine();
		System.out.println("Dime el fichero en el que debo buscar");
		ficheroDeBuscar = sc.nextLine();
		System.out.println("Dime el fichero donde debo escribir");
		String ficheroEscribir = sc.nextLine();
		
		
		Path ficheroDeLeer = Paths.get(ficheroDeBuscar);
		Path ficheroDeEscribir = Paths.get(ficheroEscribir);
		
		
		
		if (Files.exists(ficheroDeLeer) && Files.exists(ficheroDeEscribir)) {
			File file = new File(ficheroEscribir);
			file.getParentFile().mkdirs();
		}else {
			System.out.println("El fichero donde debo buscar no existe");
		}
		
	}
	
}
