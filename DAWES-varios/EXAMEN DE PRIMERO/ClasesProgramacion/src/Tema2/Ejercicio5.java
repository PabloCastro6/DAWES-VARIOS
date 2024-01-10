package Tema2;

public class Ejercicio5 {
	public static void main(String[] args) {
		float altura = 1.50f;
		boolean esMujer = false;
		
		if (esMujer) {
			if (altura < 1.35) {
			System.out.println("La mujer es enana");	
		} else if (altura > 1.35 && altura < 1.65) {
			System.out.println("La mujer es bajita");
		}else if (altura > 1.65 && altura < 1.90) {
			System.out.println("La mujer es alta");
		}else {
			System.out.println("La mujer es gigante");
		}
	} else {
		if (altura < 1.40) {
			System.out.println("El hombre es enano");
		} else if (altura > 1.40 && altura < 1.65 ) {
			System.out.println("El hombre es bajito");
		} else if (altura > 1.65 && altura < 2.00) {
			System.out.println("El hombre es alto");
		}else {
			System.out.println("El hombre es gigante");
		}
			
		}
	}

}
