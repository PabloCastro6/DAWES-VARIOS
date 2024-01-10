package Ejercicio;

public class ComparadorAltura implements Comparable<Persona> {
	
	public int compareTo(Persona otraPersona) {
		return Double.compare(this.getAltura(), otraPersona.getAltura());
	}

	private double getAltura() {
		// TODO Auto-generated method stub
		return 0;
	}

}
