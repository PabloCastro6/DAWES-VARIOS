import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		
		Persona p = new Persona();
		 
		 System.out.println("Introduce nombre para la lista");
		String nombre = scanner.nextLine();
		
		System.out.println("Introduce la edad para la lista");
		int edad = scanner.nextInt();
		scanner.nextLine();
		
		p.setNombre(nombre);
		p.setEdad(edad);
		
		 System.out.println("Información de la persona:");
	        System.out.println("Nombre: " + p.getNombre());
	        System.out.println("Edad: " + p.getEdad());
	        


	}

}
