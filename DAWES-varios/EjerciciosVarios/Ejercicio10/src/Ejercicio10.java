import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner (System.in);
		 System.out.println("Escribe un numero para empezar la secuencia");
		 
		 int numeroInicial = scanner.nextInt();
		 
		 int numero = 12;
		 int a = numeroInicial;
		 int b = numeroInicial;
		 
		 System.out.println("Secuencia Fibonacci");
		 
		 for (int i = 0; i < numero; i++) {
			 System.out.print( a + " ");
			 
			 int siguiente = a + b;
			 a = b;
			 b = siguiente;
		 }
		 

	}

}
