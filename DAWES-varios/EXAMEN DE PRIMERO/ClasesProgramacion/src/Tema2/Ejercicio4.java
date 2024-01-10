package Tema2;

public class Ejercicio4 {

	public static void main(String[] args) {
		int año = 2016;
		
		if (año % 400 == 0) {
			System.out.println("El año es bisiesto");
		} else if (año % 4 == 0 && año % 100 != 0) {
			System.out.println("El año es bisiesto");
			
		}else {
			System.out.println("No es bisiesto");
		}

	}

}
