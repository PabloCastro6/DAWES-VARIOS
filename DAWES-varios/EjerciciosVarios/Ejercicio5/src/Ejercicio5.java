
public class Ejercicio5 {

	public static void main(String[] args) {
		int numeroComparar = (int) (Math.random()*30);
		int numeroComparable;
		
		for(int i = 0; i<= 20; i++) {
			String comparar;
			numeroComparable = (int)(Math.random()*20);
			
			if(numeroComparar==numeroComparable) {
				comparar = "IGUALES";
				
			}else if (numeroComparar>numeroComparable) {
				comparar = "MAYOR";
			}else {
				comparar = "MENOR ";
			}
			
			System.out.println(" El primer numero" + numeroComparar + " es " + comparar + " que " + numeroComparable);
		}

	}

}
