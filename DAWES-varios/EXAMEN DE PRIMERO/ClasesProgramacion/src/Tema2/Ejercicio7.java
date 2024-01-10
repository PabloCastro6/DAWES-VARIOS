package Tema2;

public class Ejercicio7 {

	public static void main(String[] args) {
		int primerLado = 5;
		int segundoLado = 8;
		int tercerLado = 4;
		
		if (primerLado == segundoLado && primerLado == tercerLado) {
			System.out.println("El triangulo es equilátero");
		} else if (primerLado == segundoLado || primerLado == tercerLado || segundoLado == tercerLado) {
			System.out.println("El triangulo es isósceles");
		}else {
			System.out.println("El triangulo es escaleno");
		}
		

	}

}
