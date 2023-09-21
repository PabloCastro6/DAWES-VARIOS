import java.util.Random;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Juego de piedra, papel o tijera");
		System.out.println("Elige: ");
		Random random = new Random();
		
		String entrada = sc.nextLine();
		
		if (entrada.equals("piedra") || entrada.equals("papel") || entrada.equals("tijera")){
			String[] opciones = {"piedra", "papel", "tijera"};
			
			int indiceMaquina = random.nextInt(3);
			String eleccionMaquina = opciones[indiceMaquina];
			
			
			System.out.println("La maquina elige: " + eleccionMaquina);
			
			if (entrada.equals(eleccionMaquina)) {
				System.out.println("!EMPATE¡");
			} else if ((entrada.equals("piedra") && eleccionMaquina.equals("tijera")) || 
					(entrada.equals("papel") && eleccionMaquina.equals("piedra")) ||
                    (entrada.equals("tijera") && eleccionMaquina.equals("papel"))) {
				 System.out.println("¡Tú ganas!");
            } else {
                System.out.println("¡La maquina gana!");
            }
        } else {
            System.out.println("Entrada no válida. Por favor, elige piedra, papel o tijera.");
        }

        sc.close();
    }

			
		}


