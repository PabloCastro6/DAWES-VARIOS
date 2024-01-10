import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroSecreto = 0, numeroUsuario = 0;

        do {
            System.out.print("Introduce el número secreto [1, 10]: ");
            numeroSecreto = sc.nextInt();
            if (numeroSecreto < 1 || numeroSecreto > 10) {
                System.out.println("El número introducido está fuera del rango [1, 10]");
            }
        } while (numeroSecreto < 1 || numeroSecreto > 10);

        do {
            do {
                System.out.print("¿Cuál crees que es el número secreto? [1, 10]: ");
                numeroUsuario = sc.nextInt();
                if (numeroUsuario < 1 || numeroUsuario > 10) {
                    System.out.println("El número introducido está fuera del rango [1, 10]");
                }
            } while (numeroUsuario < 1 || numeroUsuario > 10);
            if (numeroSecreto == numeroUsuario) {
                System.out.println("=");
            } else if (numeroSecreto > numeroUsuario) {
                System.out.println("+");
            } else {
                System.out.println("-");
            }
        } while (numeroSecreto != numeroUsuario);
        sc.close();
    }
}
