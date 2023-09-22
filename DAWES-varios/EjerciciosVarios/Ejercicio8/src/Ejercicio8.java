import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
	  Scanner scanner = new Scanner (System.in);
	  
	  System.out.println("Ingrese la primera palabra");
	  String palabra1 = scanner.nextLine();
	  
	  System.out.println("Ingrese la segunda palabra");
	  String palabra2 = scanner.nextLine();
	  
	  if (palabra1.equals(palabra2)) {
		  System.out.println("Las palabras son iguales");
		  
	  }else {
		  System.out.println("Las palabras son diferentes");
	  }
	}

}
