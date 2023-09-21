import java.util.Random;

public class Ejercicio4 {

	enum nombres { Pablo, Jesus, Juan, Gonzalo, Pedro, Sonia, Adrian, Manolo };
	
	public static void main(String[] args) {
		int numRandom = (int) (Math.random() *nombres.values().length);
		
		System.out.println("Nombre aleatorio : " + nombres.values()[numRandom]);
	 
	 
			
	 
		}

	}
