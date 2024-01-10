package Tema2;

public class Ejercicio10 {

	public static void main(String[] args) {
		float Mates = 6.5f;
		float Fisica = 6f;
		float Quimica = 5f;
		float NotaMedia;
		NotaMedia = (Mates + Fisica + Quimica)/3;
		
		if ( Mates >= 6.5 && Fisica >= 6 && Quimica >= 5 || NotaMedia > 7) {
			System.out.println("El candidato es elegible");
		}else {
			System.out.println("El candidato no es elegible");
		}
		
		
		

	}

}
