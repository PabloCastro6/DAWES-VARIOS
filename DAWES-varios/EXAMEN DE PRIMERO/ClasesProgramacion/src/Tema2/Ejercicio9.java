package Tema2;

public class Ejercicio9 {

	public static void main(String[] args) {
		int x = 3;
		int y = -5;

		
		if (x > 0 && y > 0) {
			System.out.println("El punto" + x + ", y =" + y + "pertenece al cuadrante I");
		}else if (x < 0 && y > 0) {
			System.out.println("El punto" + x + ", y =" + y + "pertenece al cuadrante II ");
		}else if (x < 0 && y < 0 ) {
			System.out.println("El punto" + x + ", y =" + y + "pertenece al cuadrante III");
		}else if (x == 0 && y == 0) {
			System.out.println("El punto" + x + ", y =" + y + "pertenece al cuadrante origen");
		}else {
			System.out.println("El punto" + x + ", y =" + y + "pertenece al cuadrante IV");
		}
		
	} 

}
