
public class Ejercicio7 {

	public static void main(String[] args) {
		        System.out.println("Números primos hasta 100:");
		        
		        for (int numero = 2; numero <= 100; numero++) {
		            boolean esPrimo = true;

		            for (int i = 2; i * i <= numero; i++) {
		                if (numero % i == 0) {
		                    esPrimo = false;
		                    break;
		                }
		            }

		            if (esPrimo) {
		                System.out.print(numero + " ");
		            }
		        }
		    }
		}



