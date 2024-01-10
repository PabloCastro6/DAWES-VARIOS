package herencia;

public class Gato extends Animal {
	String raza;
	public Gato() {
		patas = 4;
	}
	
	public static void miau() {
		System.out.println("miau");
		
		
	}

	public String getRaza() {
		return raza;
	}
	
}
