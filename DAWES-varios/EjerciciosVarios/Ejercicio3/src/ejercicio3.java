
public class ejercicio3 {

	public static void main(String[] args) {

		String  nombres[] = {"Pablo", "Jesus", "Juan", "Gonzalo", "Pedro", "Sonia", "Adrian", "Manolo"};

		int numAleatorio;
		numAleatorio = (int)(Math.random()*nombres.length);
		
		System.out.println("Nombres aleatorios:" + nombres[numAleatorio]);
	}

	

	

}
