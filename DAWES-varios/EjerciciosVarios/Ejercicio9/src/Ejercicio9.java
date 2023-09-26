import java.util.Random;
import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		
			int caras = 0;
			int cruz = 0;
			
			Random rand = new Random();
			
			for (int i = 0; i < 1000000; i++) {
				
				int resultado = rand.nextInt(2);
				
				if(resultado == 0) {
					caras++;
				}else {
					cruz++;
				}
			}
			System.out.println("Resultados despues de los lanzamientos");
			System.out.println("Caras: " + caras);
			System.out.println("Cruz: " + cruz);
			
			
		}
		
		
		

	}



