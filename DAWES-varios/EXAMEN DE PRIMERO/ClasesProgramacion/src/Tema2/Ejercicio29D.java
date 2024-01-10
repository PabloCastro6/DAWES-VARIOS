package Tema2;

public class Ejercicio29D {

	public static void main(String[] args) {
		int edad = 65; 
		boolean razaNegra = true;
		int estadio = 1;
		int puntos = 0;
		
		
		if (40 <= edad && edad <=59) {
			puntos++;
		} else if (60 <= edad && edad <= 79) {
			puntos = puntos + 2;
		} else if (edad >= 80) {
			puntos = puntos + 4;
		}
		
		if (razaNegra) {
			puntos ++;	
		} 
		
		if (estadio == 3 || estadio == 4) {
			puntos = puntos + 2;
		}
		

		switch (puntos) {
		case 1:
		System.out.println("Bajo");
		break;
		
		case 2:
			System.out.println("Intermedio-bajo");
			break;
			
		case 3: 
			System.out.println("intermedio-alto");
			break;
			
		default: 
			System.out.println("alto");
			break;														
		} 
		 
	}

}
