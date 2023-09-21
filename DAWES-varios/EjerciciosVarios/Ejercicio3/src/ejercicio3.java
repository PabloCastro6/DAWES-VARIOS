
public class ejercicio3 {

	public static void main(String[] args) {

		String  nombre[] = {"Pablo", "Jesus", "Juan", "Gonzalo", "Pedro", "Sonia", "Adrian", "Manolo"};

		int nombreAletorio;
		nombreAletorio = (int)(Math.random()*nombre.length);
		
		System.out.println("Nombre aleatorio:" + nombreAleatorio);
	}

}
