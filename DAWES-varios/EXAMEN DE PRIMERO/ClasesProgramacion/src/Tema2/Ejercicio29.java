package Tema2;

public class Ejercicio29 {

	public static void main(String[] args) {
		int edad = 45;
		boolean razaNegra = true;
		int estadio = 1;
		int puntos = 0;
		
		if (40 <= edad && edad <= 59) {
			puntos = puntos + 1;
		}
		
		if (razaNegra) {
			puntos++;
		}
		
		if (60 <= edad && edad <= 79) {
			puntos = puntos + 2;
		}
		
		if (estadio == 3 || estadio == 4 ) {
			puntos = puntos + 2;
		}
		
		if (edad >= 80) {
			puntos = puntos + 4;
		}
		
		if ( puntos <= 1) {
			System.out.println("Bajo");
		}
		 if (puntos == 2) {
			 System.out.println("Intermedio-bajo");
		 } 
		  if (puntos == 3) {
			  System.out.println("Intermedio-alto");
		  }
		  if ( puntos >= 4) {
			  System.out.println("Alto");
		  }
 
	} 

}
