
public class Ejercicio6 {

	public static void main(String[] args) {
		float metros = 5f;
		int numeroHoras = 13;
		int numeroMinutos = 4;
		int numeroSegundos = 7;

		float velocidad;
	
		
//		velocidad = metros / (numeroHoras * 3600 + numeroMinutos * 60 + numeroSegundos);
		velocidad = 3800;
		
		velocidad += numeroMinutos * 60 ;
		velocidad = (metros / numeroSegundos);
		
		
		System.out.println("La velocidad en la que se ha recorrido los " + metros + " metros es " + velocidad + " metros/segundo");
		

	}

}
