package Tema2;

public class Ejercicio14 {

	public static void main(String[] args) {
		int resultado;
		
		System.out.println( "Las tablas de multiplicar del 1 al 10 son: ");
		System.out.println("======================================");
		
		for (int x = 1;  x <= 9; x++ ) {
			for (int i = 1; i < 10; i++ ) {
				resultado= x*i;
				System.out.print(x + " x " + i + " = " + resultado + " | ");
			}
			System.out.println();
		}
		

	}

}
