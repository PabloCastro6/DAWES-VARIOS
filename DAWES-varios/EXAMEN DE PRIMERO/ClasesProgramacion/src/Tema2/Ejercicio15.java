package Tema2;

public class Ejercicio15 {

	public static void main(String[] args) {
		int limite = 7, semillaUno = 0, semillaDos = 1, suma = 1;
		
		System.out.print("Seria de fibonacce con límite" + limite + "y son semillas" + semillaUno + " y " + "semillaDos" + "es;" + semillaUno + ",");
		
		for (int i = 1; i < limite; i++) {
			System.out.print(suma);
			suma = semillaUno + semillaDos;
			semillaUno = semillaDos;
			semillaDos = suma;
			
			if (i < (limite - 1)) {
				System.out.print(",");
			}
		}

		System.out.println(".");
	}

}
