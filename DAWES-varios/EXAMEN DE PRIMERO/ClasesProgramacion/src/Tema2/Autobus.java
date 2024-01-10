package Tema2;

public class Autobus {

	public static void main(String[] args) {
		int distancia = 520;
		int personas = 4;
		double recargo = 0;
		double costo = 0;
		costo = 20 * personas;
		
		if (distancia > 200) {
			costo = costo + (0.03 * (distancia - 200));
		}
		
		if (distancia > 400) {
			costo = costo - (costo * 0.15);
			
		}
		
		if (personas >= 3) {
			costo = costo - (costo * 0.10);
		}
		
		System.out.println("Coste total " + costo);
	}

}
