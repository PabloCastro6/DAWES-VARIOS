
public class Ejercicio5 {

	public static void main(String[] args) {
		int numero = -5;
		int numero2 = 8;
		int numero3 = 6;
		int numero4 = 55;
		int numero5 = 9;
		int numero6 = 20;
		int numero7 = -3;
		int numero8 = 5;
		int numero9 = 15;
		int numero10 = 3;
		int numero11 = 2;
		int resultado;
		
		resultado = numero + (numero2 * numero3);
		System.out.println ("El resultado es " + resultado);
		
		resultado = (numero4 + numero5)%numero5;
		System.out.println("El resultado es " + resultado);
		
		resultado = numero6 + (numero7)*(numero8) / numero2;
		System.out.println("El resultado es " + resultado);
		
		resultado = numero8 + (numero9 / numero10) * numero11 - (numero2 % numero10);
		System.out.println("El resultado es " + resultado);
		
	}
}
