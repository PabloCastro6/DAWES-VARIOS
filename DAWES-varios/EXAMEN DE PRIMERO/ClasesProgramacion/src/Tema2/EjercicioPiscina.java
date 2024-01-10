package Tema2;

public class EjercicioPiscina {

	public static void main(String[] args) {
		int volumenPiscina = 100;
		float cubo = 1.3f;
		float piscina = 0f;
		int contador = 0;
		
		while (piscina <= volumenPiscina) {
			piscina = piscina + cubo ;
			contador++;
			
			if (piscina + cubo > volumenPiscina) {
				System.out.println("ya ha terminado");		
				break;
			}
			
		}  
		
		System.out.println("Se han utilizado" + contador + "cubos" );
	}
}
