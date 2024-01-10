package Tema2;

import java.util.Scanner;

public class Numeros {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        
        System.out.print("Introduce el número secreto entre 1 y 10: ");
        int numeroSecreto = scanner.nextInt();

        
        if (numeroSecreto < 1 || numeroSecreto > 10) {
            System.out.println("Número secreto no válido.");
            return;
        }

        int numeroAdivinar;
        boolean noAcertado = true;

        do {
            
            System.out.print("Adivina el número): ");
            numeroAdivinar = scanner.nextInt();

            if (numeroAdivinar < numeroSecreto) {
                System.out.println("El número es mayor.");
            } else if (numeroAdivinar > numeroSecreto) {
                System.out.println("El número es menor.");
            } else {
                noAcertado = false;
                System.out.println("Has adivinado el número secreto.");
            }
        } while (noAcertado);

   
    	 
     }
    }


	


