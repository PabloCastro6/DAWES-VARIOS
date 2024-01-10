
public class Ejercicio14 {

	public static void main(String[] args) {
		float radio = 4;
		int α = 40;
		float β=0.698f;
		float pi = 3.1415f;
		float longitud;
		longitud = (pi*radio*radio*α/360*2)/radio;
		
		System.out.println("El area del circulo con longitud el arco exterior de " +longitud+ " y el radio " +radio+ " es "+ (longitud*radio/2));
		System.out.println("El area del circulo con radio " +radio+ " y con " + α + " grados del sector es " + (pi*radio*radio*α/360));
		System.out.println ("El area del circulo con radio " + radio + " y con " + β +" Expresando en radiantes es "+ (radio*radio*β/2));

	}

}
