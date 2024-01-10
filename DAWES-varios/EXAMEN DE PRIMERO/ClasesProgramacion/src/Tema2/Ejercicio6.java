package Tema2;

public class Ejercicio6 {

	public static void main(String[] args) {
		char letra = 'L';
		
		if('a' <= letra && letra <= 'z') {
			System.out.println("La letra " + letra + " es minuscula");
		}else if ('A' <= letra && letra <= 'Z') {
			System.out.println("La letra " + letra + " es mayuscula");
			
		}else {
			System.out.println("El caracter " + letra + " no es una letra");
		}
	} 

}
